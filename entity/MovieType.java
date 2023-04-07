package entity;

public enum MovieType {
    ACTION(1,"Aksiyon"),
    COMEDY(2,"Komedi"),
    HORROR(3,"Korku"),
    SCIENCEFICTON(4,"Bilim Kurgu"),
    LOVE(5,"Aşk"),
    DRAMEDY(6,"Drama");

    MovieType(int no, String explanation) {
        this.no = no;
        this.explanation = explanation;
    }

    private final int no;
    private final String explanation;
    public int getNo() {
        return no;    }

    public String getExplanation() {
        return explanation;
    }

}
