package com.domedo.domedouser.du_common;

import com.domedo.objects.constants.AppConstants;
import com.domedo.objects.exceptions.DomedoDBException;
import com.domedo.objects.pojos.ErrorCodes;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Arpit Srivastava <a> mailTo: iarpitsrivastava06@gmail.com</a>
 */
@Slf4j
public class CustomHouseIdGenerator implements IdentifierGenerator {

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object o) throws HibernateException {
        String prefix = "HOUSE-";
        Connection connection = session.connection();

        try {
            Statement statement=connection.createStatement();

            ResultSet rs=statement.executeQuery("select count(houseId) as Id from USER_ADDRESS;");

            if(rs.next())
            {
                int id=rs.getInt(1)+101;
                String generatedId = prefix + new Integer(id).toString();
                log.info("Generated User House Id: " + generatedId);
                return generatedId;
            }
        } catch (SQLException e) {
            log.error("Error generating user HouseId. Error is {}", e.getMessage());
            throw new DomedoDBException(e.getMessage(), ErrorCodes.HOUSE_UUID_GENERATOR_EXCEPTION);
        }
        return null;
    }
}
