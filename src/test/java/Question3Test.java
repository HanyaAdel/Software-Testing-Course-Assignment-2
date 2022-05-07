import org.junit.jupiter.api.*;

class Question3Test {

    Question3 question;

    @BeforeEach
    public void init (){
        question = new Question3();
    }

    @Nested
    public class TC_EdgeCoverage {

        @Nested
        public class TestNormal {
            @Test
            public void normalTimeToNormalDate() {
                question.handleQuestion('a');
                Assertions.assertEquals("NORMAL-DATE", question.displayCurrentState());
                Assertions.assertEquals("2000-1-1", question.displayDate());
                Assertions.assertEquals("0:0", question.displayTime());
            }

            @Test
            public void normalDateToNormalTime() {
                question.handleQuestion('a');
                question.handleQuestion('a');
                Assertions.assertEquals("NORMAL-TIME", question.displayCurrentState());
                Assertions.assertEquals("2000-1-1", question.displayDate());
                Assertions.assertEquals("0:0", question.displayTime());
            }

                @Test
                public void normalTimeToAlarmAlarm() {
                    question.handleQuestion('b');
                    Assertions.assertEquals("ALARM-ALARM", question.displayCurrentState());
                    Assertions.assertEquals("2000-1-1", question.displayDate());
                    Assertions.assertEquals("0:0", question.displayTime());
                }


                @Test
                public void normalTimeToUpdateMin() {
                    question.handleQuestion('c');
                    Assertions.assertEquals("UPDATE-MIN", question.displayCurrentState());
                    Assertions.assertEquals("2000-1-1", question.displayDate());
                    Assertions.assertEquals("0:0", question.displayTime());
                }

                @AfterEach
                public void clean() {
                    question = null;
                }

            }



            @Nested
            public class TestAlarm {
                @Test
                public void normalTimeToNormalDate() {
                    question.handleQuestion('b');
                    question.handleQuestion('a');
                    Assertions.assertEquals("ALARM-CHIME", question.displayCurrentState());
                    Assertions.assertEquals("2000-1-1", question.displayDate());
                    Assertions.assertEquals("0:0", question.displayTime());
                }

                @Test
                public void normalDateToNormalTime() {
                    question.handleQuestion('b');
                    question.handleQuestion('d');
                    Assertions.assertEquals("NORMAL-TIME", question.displayCurrentState());
                    Assertions.assertEquals("2000-1-1", question.displayDate());
                    Assertions.assertEquals("0:0", question.displayTime());
                }

                @AfterEach
                public void clean() {
                    question = null;
                }

            }


            @Nested
            public class TestUpdate {
                @Test
                public void updateMinToUpdateHour() {
                    question.handleQuestion('c');
                    question.handleQuestion('a');

                    Assertions.assertEquals("UPDATE-HOUR", question.displayCurrentState());
                    Assertions.assertEquals("2000-1-1", question.displayDate());
                    Assertions.assertEquals("0:0", question.displayTime());
                }

                @Test
                public void updateHourToUpdateDay() {
                    question.handleQuestion('c');
                    question.handleQuestion('a');
                    question.handleQuestion('a');
                    Assertions.assertEquals("UPDATE-DAY", question.displayCurrentState());
                    Assertions.assertEquals("2000-1-1", question.displayDate());
                    Assertions.assertEquals("0:0", question.displayTime());
                }

                @Test
                public void updateDayToUpdateMonth() {
                    question.handleQuestion('c');
                    question.handleQuestion('a');
                    question.handleQuestion('a');
                    question.handleQuestion('a');
                    Assertions.assertEquals("UPDATE-MONTH", question.displayCurrentState());
                    Assertions.assertEquals("2000-1-1", question.displayDate());
                    Assertions.assertEquals("0:0", question.displayTime());
                }


                @Test
                public void updateMonthToUpdateYear() {
                    question.handleQuestion('c');
                    question.handleQuestion('a');
                    question.handleQuestion('a');
                    question.handleQuestion('a');
                    question.handleQuestion('a');
                    Assertions.assertEquals("UPDATE-YEAR", question.displayCurrentState());
                    Assertions.assertEquals("2000-1-1", question.displayDate());
                    Assertions.assertEquals("0:0", question.displayTime());
                }


                @Test
                public void updateYearToNormal() {
                    question.handleQuestion('c');
                    question.handleQuestion('a');
                    question.handleQuestion('a');
                    question.handleQuestion('a');
                    question.handleQuestion('a');
                    question.handleQuestion('a');
                    Assertions.assertEquals("NORMAL-TIME", question.displayCurrentState());
                    Assertions.assertEquals("2000-1-1", question.displayDate());
                    Assertions.assertEquals("0:0", question.displayTime());
                }

                @Test
                public void UpdateToNormal() {
                    question.handleQuestion('c');
                    question.handleQuestion('d');
                    Assertions.assertEquals("NORMAL-TIME", question.displayCurrentState());
                    Assertions.assertEquals("2000-1-1", question.displayDate());
                    Assertions.assertEquals("0:0", question.displayTime());
                }

                @Test
                public void minUpdate() {
                    question.handleQuestion('c');
                    question.handleQuestion('b');
                    Assertions.assertEquals("UPDATE-MIN", question.displayCurrentState());
                    Assertions.assertEquals("2000-1-1", question.displayDate());
                    Assertions.assertEquals("0:1", question.displayTime());
                }

                @Test
                public void hourUpdate() {
                    question.handleQuestion('c');
                    question.handleQuestion('a');
                    question.handleQuestion('b');
                    Assertions.assertEquals("UPDATE-HOUR", question.displayCurrentState());
                    Assertions.assertEquals("2000-1-1", question.displayDate());
                    Assertions.assertEquals("1:0", question.displayTime());
                }

                @Test
                public void dayUpdate() {
                    question.handleQuestion('c');
                    question.handleQuestion('a');
                    question.handleQuestion('a');
                    question.handleQuestion('b');
                    Assertions.assertEquals("UPDATE-DAY", question.displayCurrentState());
                    Assertions.assertEquals("2000-1-2", question.displayDate());
                    Assertions.assertEquals("0:0", question.displayTime());
                }


                @Test
                public void monthUpdate() {
                    question.handleQuestion('c');
                    question.handleQuestion('a');
                    question.handleQuestion('a');
                    question.handleQuestion('a');
                    question.handleQuestion('b');
                    Assertions.assertEquals("UPDATE-MONTH", question.displayCurrentState());
                    Assertions.assertEquals("2000-2-1", question.displayDate());
                    Assertions.assertEquals("0:0", question.displayTime());
                }


                @Test
                public void yearUpdate() {
                    question.handleQuestion('c');
                    question.handleQuestion('a');
                    question.handleQuestion('a');
                    question.handleQuestion('a');
                    question.handleQuestion('a');
                    question.handleQuestion('b');
                    Assertions.assertEquals("UPDATE-YEAR", question.displayCurrentState());
                    Assertions.assertEquals("2001-1-1", question.displayDate());
                    Assertions.assertEquals("0:0", question.displayTime());
                }

                @AfterEach
                public void cleac() {
                    question = null;
                }

            }
        }

        @Nested
        public class TC_ADU {

            @Test
            public void minUpdate() {
                question.handleQuestion('c');
                question.handleQuestion('b');
                Assertions.assertEquals("UPDATE-MIN", question.displayCurrentState());
                Assertions.assertEquals("2000-1-1", question.displayDate());
                Assertions.assertEquals("0:1", question.displayTime());
            }

            @Test
            public void hourUpdate() { // UPDATE-HOUR
                question.handleQuestion('c');
                question.handleQuestion('a');
                question.handleQuestion('b');
                Assertions.assertEquals("UPDATE-HOUR", question.displayCurrentState());
                Assertions.assertEquals("2000-1-1", question.displayDate());
                Assertions.assertEquals("1:0", question.displayTime());
            }

            @Test
            public void dayUpdate() {
                question.handleQuestion('c');
                question.handleQuestion('a');
                question.handleQuestion('a');
                question.handleQuestion('b');
                Assertions.assertEquals("UPDATE-DAY", question.displayCurrentState());
                Assertions.assertEquals("2000-1-2", question.displayDate());
                Assertions.assertEquals("0:0", question.displayTime());
            }


            @Test
            public void monthUpdate() {
                question.handleQuestion('c');
                question.handleQuestion('a');
                question.handleQuestion('a');
                question.handleQuestion('a');
                question.handleQuestion('b');
                Assertions.assertEquals("UPDATE-MONTH", question.displayCurrentState());
                Assertions.assertEquals("2000-2-1", question.displayDate());
                Assertions.assertEquals("0:0", question.displayTime());
            }


            @Test
            public void yearUpdate() {
                question.handleQuestion('c');
                question.handleQuestion('a');
                question.handleQuestion('a');
                question.handleQuestion('a');
                question.handleQuestion('a');
                question.handleQuestion('b');
                Assertions.assertEquals("UPDATE-YEAR", question.displayCurrentState());
                Assertions.assertEquals("2001-1-1", question.displayDate());
                Assertions.assertEquals("0:0", question.displayTime());
            }



            @Test
            public void minUpdate2() {
                question.handleQuestion('c');
                question.handleQuestion('b');
                question.handleQuestion('b');
                Assertions.assertEquals("UPDATE-MIN", question.displayCurrentState());
                Assertions.assertEquals("2000-1-1", question.displayDate());
                Assertions.assertEquals("0:2", question.displayTime());
            }

            @Test
            public void hourUpdate2() {
                question.handleQuestion('c');
                question.handleQuestion('a');
                question.handleQuestion('b');
                question.handleQuestion('b');
                Assertions.assertEquals("UPDATE-HOUR", question.displayCurrentState());
                Assertions.assertEquals("2000-1-1", question.displayDate());
                Assertions.assertEquals("2:0", question.displayTime());
            }

            @Test
            public void dayUpdate2() {
                question.handleQuestion('c');
                question.handleQuestion('a');
                question.handleQuestion('a');
                question.handleQuestion('b');
                question.handleQuestion('b');
                Assertions.assertEquals("UPDATE-DAY", question.displayCurrentState());
                Assertions.assertEquals("2000-1-3", question.displayDate());
                Assertions.assertEquals("0:0", question.displayTime());
            }


            @Test
            public void monthUpdate2() {
                question.handleQuestion('c');
                question.handleQuestion('a');
                question.handleQuestion('a');
                question.handleQuestion('a');
                question.handleQuestion('b');
                question.handleQuestion('b');
                Assertions.assertEquals("UPDATE-MONTH", question.displayCurrentState());
                Assertions.assertEquals("2000-3-1", question.displayDate());
                Assertions.assertEquals("0:0", question.displayTime());
            }


            @Test
            public void yearUpdate2() {
                question.handleQuestion('c');
                question.handleQuestion('a');
                question.handleQuestion('a');
                question.handleQuestion('a');
                question.handleQuestion('a');
                question.handleQuestion('b');
                question.handleQuestion('b');
                Assertions.assertEquals("UPDATE-YEAR", question.displayCurrentState());
                Assertions.assertEquals("2002-1-1", question.displayDate());
                Assertions.assertEquals("0:0", question.displayTime());
            }


            @AfterEach
            public void clean() {
                question = null;
            }

        }

        @AfterEach
        public void clear(){
            question = null;
        }
}