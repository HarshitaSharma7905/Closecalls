package com.example.closecalls;

import java.util.ArrayList;

public class MatchDetailsModel {
    private Data data;

    public MatchDetailsModel(Data data) {
        this.data = data;
    }

    public Data getData() {
        return data;
    }

    public class Data{
        private String curr_rate;
        private  String target;
        private  String rr_rate;
        private String run_need;
        private String ball_rem;
        private  LastWicket lastwicket;
         private Partnership partnership;
          private Last36Balls  last36ball;

        public Data(String curr_rate, String target, String rr_rate, String run_need, String ball_rem, LastWicket lastwicket, Partnership partnership, Last36Balls last36ball) {
            this.curr_rate = curr_rate;
            this.target = target;
            this.rr_rate = rr_rate;
            this.run_need = run_need;
            this.ball_rem = ball_rem;
            this.lastwicket = lastwicket;
            this.partnership = partnership;
            this.last36ball = last36ball;
        }

        public String getCurr_rate() {
            return curr_rate;
        }

        public String getTarget() {
            return target;
        }

        public String getRr_rate() {
            return rr_rate;
        }

        public String getRun_need() {
            return run_need;
        }

        public String getBall_rem() {
            return ball_rem;
        }

        public LastWicket getLastwicket() {
            return lastwicket;
        }

        public Partnership getPartnership() {
            return partnership;
        }

        public Last36Balls getLast36ball() {
            return last36ball;
        }
        public  class  LastWicket{
             private String player;
             private String run;
             private String ball;

            public LastWicket(String player, String run, String ball) {
                this.player = player;
                this.run = run;
                this.ball = ball;
            }

            public String getPlayer() {
                return player;
            }

            public String getRun() {
                return run;
            }

            public String getBall() {
                return ball;
            }
        }
        public  class  Partnership{
             private String run;
             private  String ball;

            public Partnership(String run, String ball) {
                this.run = run;
                this.ball = ball;
            }

            public String getRun() {
                return run;
            }

            public String getBall() {
                return ball;
            }
        }
        public  class  Last36Balls{
            private ArrayList<MatchDetailsModel.Data.Last36Balls> list;

            public Last36Balls(ArrayList<Last36Balls> list) {
                this.list = list;
            }

            public ArrayList<Last36Balls> getList() {
                return list;
            }
        }
    }
}
