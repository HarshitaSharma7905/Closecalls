package com.example.closecalls;

import java.util.ArrayList;

public class HomeModel {
    String status;
    String msg;
    ArrayList<data> data;

    public HomeModel(String status, String msg) {
        this.status = status;
        this.msg = msg;

    }

    public String getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }

    public ArrayList<HomeModel.data> getData() {
        return data;
    }

    public class data{
        String match_id;
        String series;
        String team_a_short	;
        String team_b_short;
        String team_a_img;
        String team_b_img;
        String venue;
        String match_type;
        String match_time;
        String match_date;
        String match_status;

        public String getMatch_id() {
            return match_id;
        }

        public String getSeries() {
            return series;
        }

        public String getTeam_a_short() {
            return team_a_short;
        }

        public String getTeam_b_short() {
            return team_b_short;
        }

        public String getTeam_a_img() {
            return team_a_img;
        }

        public String getTeam_b_img() {
            return team_b_img;
        }

        public String getVenue() {
            return venue;
        }

        public String getMatch_type() {
            return match_type;
        }

        public String getMatch_time() {
            return match_time;
        }

        public String getMatch_date() {
            return match_date;
        }

        public String getMatch_status() {
            return match_status;
        }
    }
}
