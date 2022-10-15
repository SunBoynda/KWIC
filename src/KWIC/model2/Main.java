package KWIC.model2;

public class Main {
    public static void main(String[] args) {
        Input input = new Input();
        String path = KWIC.UI.Main.filePath;
        input.input(path);
        Shift shift = new Shift(input.getLineTxt());
        shift.shift();
        Alphabetizer alphabetizer = new Alphabetizer(shift.getKwicList());
        alphabetizer.sort();
        Output output = new Output(alphabetizer.getKwicList());
        output.output("D:\\output.txt");

    }
}
