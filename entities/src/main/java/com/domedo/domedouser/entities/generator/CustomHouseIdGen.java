//package com.domedo.domedouser.entities.generator;
//
//import com.domedo.domedouser.entities.UserAddress;
//import org.hibernate.Session;
//import org.hibernate.query.NativeQuery;
//import org.hibernate.query.Query;
//import org.hibernate.tuple.ValueGenerator;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//import static org.hibernate.FlushMode.COMMIT;
//
///**
// * @author Arpit Srivastava <a> mailTo: iarpitsrivastava06@gmail.com</a>
// */
//public class CustomHouseIdGen extends ValueGenerator<String> {
//    private static final String TODAY_EXAMPLE_QUERY = "from Example where createDate>:start and createDate<:end order by createDate desc";
//    private static final String START_PARAMETER = "start";
//    private static final String END_PARAMETER = "end";
//    private static final String NEXTVAL_QUERY = "select EXAMPLE_SEQ.nextval from dual";
//    private final SimpleDateFormat dataFormat = new SimpleDateFormat("yyyyMMdd");
//
//    @Override
//    public String generateValue(Session session, Object owner) {
//        Date now = new Date();
//        Query<UserAddress> query = session.createQuery(TODAY_EXAMPLE_QUERY, UserAddress.class);
//        query.setParameter(START_PARAMETER, now);
//        query.setParameter(END_PARAMETER, new Date());
//        UserAddress lastExample = query.setMaxResult(1).setHibernateFlushMode(COMMIT).uniqueResult();
//
//        NativeQuery nextvalQuery = session.createSQLQuery(NEXTVAL_QUERY);
//        Number nextvalValue = (Number) nextvalQuery.setFlushMode(COMMIT).uniqueResult();
//        return dataFormat.format(now) + someParameter(lastExample) + nextvalValue.longValue();
//    }
//}
