package chapter_12_4_1;

public class SpecialDisountCommand extends Command {

    @Override
    public void execute() {
        double amount = book.getAmout();
        book.setAmount(amount * 0.7);
    }
}
