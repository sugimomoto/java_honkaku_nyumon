package chapter_12_2_2;

public class TopPageBuilder implements Builder {

    private TopPage page;

    public TopPageBuilder(){
        this.page = new TopPage();
    }

    @Override
    public void createHeader() {
        this.page.setHeader("Top Page Header");
    }

    @Override
    public void createContents() {
        this.page.setContents("Top Page Contents");
        
    }

    @Override
    public void createFooter() {
        this.page.setFooter("Top Page Footer");
        
    }

    @Override
    public Page getResult() {
        return this.page;
    }
    
}
