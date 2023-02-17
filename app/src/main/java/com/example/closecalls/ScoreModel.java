package com.example.closecalls;


import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ScoreModel {
    private String status;
    private String msg;
    private DataTeam data;

    public String getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }

    public DataTeam getData() {
        return data;
    }

    public class DataTeam {
        private String result;
        private ScorecardTeam scorecard;

        public String getResult() {
            return result;
        }

        public ScorecardTeam getScorecard() {
            return scorecard;
        }

        public class ScorecardTeam {
            @SerializedName("1")
            private TeamA teamA;
            @SerializedName("2")
            private TeamB teamB;

            public TeamA getTeamA() {
                return teamA;
            }

            public TeamB getTeamB() {
                return teamB;
            }

            public class TeamA {
                private TeamAScore team;

                public TeamAScore getTeam() {
                    return team;
                }

                private  ArrayList<ScoreModel.DataTeam.ScorecardTeam.TeamA.Batsman> batsman;
                private  ArrayList<ScoreModel.DataTeam.ScorecardTeam.TeamA.Bolwer> bolwer;

                public ArrayList<Bolwer> getBolwer() {
                    return bolwer;
                }

                public ArrayList<Batsman> getBatsman() {
                    return batsman;
                }

                public TeamAScore getTeamAScore() {
                    return team;
                }

                public class TeamAScore {
                    private String team_id;
                    private String name;
                    private String short_name;
                    private String flag;
                    private String score;
                    private String wicket;
                    private String over;
                    private String extras;

                    public String getTeam_id() {
                        return team_id;
                    }

                    public String getName() {
                        return name;
                    }

                    public String getShort_name() {
                        return short_name;
                    }

                    public String getFlag() {
                        return flag;
                    }

                    public String getScore() {
                        return score;
                    }

                    public String getWicket() {
                        return wicket;
                    }

                    public String getOver() {
                        return over;
                    }

                    public String getExtras() {
                        return extras;
                    }
                }

                public class Batsman {
                    private String name;
                    private  String run;
                    private  String ball;
                    private  String fours;
                    private  String sixes;
                    private  String strike_rate;
                    private  String out_by;

                    public String getName() {
                        return name;
                    }

                    public String getRun() {
                        return run;
                    }

                    public String getBall() {
                        return ball;
                    }

                    public String getFours() {
                        return fours;
                    }

                    public String getSixes() {
                        return sixes;
                    }

                    public String getStrike_rate() {
                        return strike_rate;
                    }

                    public String getOut_by() {
                        return out_by;
                    }
                }

                public class Bolwer {
                    private String  name;
                    private  String over;
                    private  String maiden;
                    private  String run;
                    private  String wicket;
                    private  String economy;
                    private  String dot_bal;

                    public String getName() {
                        return name;
                    }

                    public String getOver() {
                        return over;
                    }

                    public String getMaiden() {
                        return maiden;
                    }

                    public String getRun() {
                        return run;
                    }

                    public String getWicket() {
                        return wicket;
                    }

                    public String getEconomy() {
                        return economy;
                    }

                    public String getDot_bal() {
                        return dot_bal;
                    }
                }
            }

            public class TeamB {
                private TeamBScore team;;
                private ArrayList<ScoreModel.DataTeam.ScorecardTeam.TeamB.Batsman> batsman;
                private ArrayList<ScoreModel.DataTeam.ScorecardTeam.TeamB.Bolwer> bolwer;

                public TeamBScore getTeam() {
                    return team;
                }

                public ArrayList<Bolwer> getBolwer() {
                    return bolwer;
                }

                public ArrayList<TeamB.Batsman> getBatsman() {
                    return batsman;
                }



                public TeamBScore getTeamBScore() {
                    return team;
                }

                public class TeamBScore {
                    private String team_id;
                    private String name;
                    private String short_name;
                    private String flag;
                    private String score;
                    private String wicket;
                    private String over;
                    private String extras;

                    public String getTeam_id() {
                        return team_id;
                    }

                    public String getName() {
                        return name;
                    }

                    public String getShort_name() {
                        return short_name;
                    }

                    public String getFlag() {
                        return flag;
                    }

                    public String getScore() {
                        return score;
                    }

                    public String getWicket() {
                        return wicket;
                    }

                    public String getOver() {
                        return over;
                    }

                    public String getExtras() {
                        return extras;
                    }
                }

                private class Batsman {
                    private String name;
                    private  String run;
                    private  String ball;
                    private  String fours;
                    private  String sixes;
                    private  String strike_rate;
                    private  String out_by;

                    public String getName() {
                        return name;
                    }

                    public String getRun() {
                        return run;
                    }

                    public String getBall() {
                        return ball;
                    }

                    public String getFours() {
                        return fours;
                    }

                    public String getSixes() {
                        return sixes;
                    }

                    public String getStrike_rate() {
                        return strike_rate;
                    }

                    public String getOut_by() {
                        return out_by;
                    }
                }

                public class Bolwer {
                    private String  name;
                    private  String over;
                    private  String maiden;
                    private  String run;
                    private  String wicket;
                    private  String economy;
                    private  String dot_bal;

                    public String getName() {
                        return name;
                    }

                    public String getOver() {
                        return over;
                    }

                    public String getMaiden() {
                        return maiden;
                    }

                    public String getRun() {
                        return run;
                    }

                    public String getWicket() {
                        return wicket;
                    }

                    public String getEconomy() {
                        return economy;
                    }

                    public String getDot_bal() {
                        return dot_bal;
                    }
                }
            }
        }
    }

}

