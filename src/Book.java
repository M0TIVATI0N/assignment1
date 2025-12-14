import java.time.Year;

public class Book {
    private int id;
    private String title;
    private String author;
    private int year;
    private static int idGen = 1;
    private boolean available;

    public Book(){
        this.id = idGen++;
        this.available = true;
    }

    public Book(String title, String author, int year){
        this();
        setAuthor(author);
        setTitle(title);
        setYear(year);
    }

        public int getId(){
            return id;
        }

        //public void setId(double newId){
        //}

        public String getTitle(){
            return title;
        }

        public void setTitle(String newTitle){
            if (newTitle == null || newTitle.trim().isEmpty()){
                throw new IllegalArgumentException();
            }
            this.title = newTitle;
        }

        public String getAuthor(){
            return author;
        }

        public void setAuthor(String newAuthor){
            if (newAuthor == null || newAuthor.trim().isEmpty()){
                throw new IllegalArgumentException();
            }
            this.author = newAuthor;
        }

        public int getYear(){
            return year;
        }

        public void setYear(int newYear){
            int currentYear = Year.now().getValue();
            if (newYear < 1500 || newYear > currentYear){
                throw new IllegalArgumentException();
            }
            this.year = newYear;
        }

        public boolean getAvailable(){
            return available;
        }

        public void setAvailable(boolean newAvailable){
            this.available = newAvailable;
        }

        public void markAsBorrowed(){
            this.available = false;
        }

        public void markAsReturned(){
            this.available = true;
        }
        @Override
        public String toString() {
            return String.format("book => id = %d, title = '%s', author = '%s', year = %d, available = %s", id, title, author, year, available ? "Yes" : "No");
        }

}
