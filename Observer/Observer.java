/***
 * Observer 패턴!
 * 
 * 
 * 
 *  */import java.util.List;
import java.util.ArrayList;

interface Observer {
    public void update(String title, String news);
}

interface Publisher {
    public void add(Observer observer);

    public void delete(Observer observer);

    public void notifyObserver();
}

class NewsMachine implements Publisher {
    private List<Observer> observers;
    private String title;
    private String news;

    public NewsMachine() {
        observers = new ArrayList<>();
    }

    @Override
    public void add(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void delete(Observer observer){
        int index = observers.indexOf(observer);
        observers.remove(index);
    }

    @Override
    public void notifyObserver() {
        for(Observer observer : observers){
            observer.update(title, news);
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title, String news) {
        this.title = title;
        this.news = news;
    }

    public String getNews() {
        return news;
    }
    


    
}

class AnnualSubscriber implements Observer{
    private String newsString;
    private Publisher publisher;

    public AnnualSubscriber(String newsString, Publisher publisher) {
        this.newsString = newsString;
        this.publisher = publisher;
    }

    
}
