package Database;

/**
 * Created by nnguy637 on 12/11/2015.
 */
public class MilestoneDbSchema {
    public static final class MilestonesTable{
        public static final String NAME = "milestones";

        public static final class Cols{
            public static final String UUID = "uuid";
            public static final String PROJECT_ID = "projectId";
            public static final String MILESTONE_GOAL = "msTitle";
            public static final String IS_COMPLETED = "isCompleted";
        }
    }
}
