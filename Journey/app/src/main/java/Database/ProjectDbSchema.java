package Database;

import java.util.Date;

/**
 * Created by nnguy637 on 12/8/2015.
 */
public class ProjectDbSchema {
    public static final class ProjectTable{
        public static final String NAME = "projects";

            public static final class Cols{
                public static final String UUID = "uuid";
                public static final String TITLE = "title";
                public static final String DESCRIPTION = "description";
                public static final String START_DATE = "start_date";
                public static final String END_DATE = "end_date";
            }
    }
}
