class JMAS_Player implements Comparable<JMAS_Player> {
    public String name;
    public String password;
    public int bestScore;

    public JMAS_Player(String name, String password, int bestScore) {
        this.name = name;
        this.password = password;
        this.bestScore = bestScore;
    }

    public String getName() {
        return this.name;
    }
    
    public String getPassword() {
        return this.password;
    }

    public int getBestScore() {
        return this.bestScore;
    }

    public void setBestScore(int score) {
        this.bestScore = score;
    }

    @Override
    public String toString() {
        return name + "[pass=" + password + "]" + bestScore;
    }

    @Override
    public int compareTo(JMAS_Player p) {
        return this.name.compareTo(p.name);
    }
}