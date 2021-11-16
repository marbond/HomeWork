package MusicSystem;

/**
 * Класс, который описывает объекты типа Флеш-карта,
 * с полями: Название Флеш-карты, Список песен, Кол-во песен
 * с методами: Получить название Флеш-карты, Добавить песню, Удалить песню,
 * Получить список песен, Поличить кол-во песен
 * */

public class FlashCard implements SongCarrier {

    //Поля
    String NameFlashCard;
    Song[] Songs = new Song[4999];
    int NumberOfSongs = 0;

    //Конструктор
    FlashCard (String NameFlashCard){
        this.NameFlashCard = NameFlashCard;
    }

    //Метод Получить название Флеш-карты
    String getNameFlashCard() {
        return this.NameFlashCard;
    }

    //Метод Получить список песен
    public Song[] getSongs() {
        return this.Songs;
    }

    //Метод Получить кол-во песен
    public int getNumberOfSongs() {
        return this.NumberOfSongs;
    }

    //Метод Добавить песню
    public void addSong(String AuthorSong, String NameSong) {

        //Проверка Флеш-карты на заполненность
        if (this.NumberOfSongs == 5000){
            System.out.println("Нельзя добавить песню на Флеш-карту, так как она полностью заполнена!");
        }

        //Добавление песни
        else {
            this.Songs[this.NumberOfSongs] = new Song(AuthorSong, NameSong);
            this.NumberOfSongs = this.NumberOfSongs + 1;
        }

    }

    //Метод Удалить песню
    public void DeleteSong(String AuthorSong, String NameSong) {

        //Доп. переменная для проверки удаления
        int NumberOfSongsBefore = this.NumberOfSongs;

        //Поиск песни в списке
        for (int i = 0; i < this.NumberOfSongs; i++) {

            if ((this.Songs[i].getAuthorSong() == AuthorSong) & (this.Songs[i].getNameSong() == NameSong)) {
                this.Songs[i] = null;

                //Удаление со сдвигом
                for (int j = i; j < this.NumberOfSongs - 1; j++) {
                    this.Songs[j] = this.Songs[j + 1];
                }

                NumberOfSongsBefore = NumberOfSongsBefore - 1;
            }

        }

        //Проверка было ли удаление
        if (NumberOfSongsBefore == this.NumberOfSongs) {
            System.out.println("Нельзя удалить песню с Флеш-карты, так как данной песни нет на Флеш-карте");
        }
        else {
            this.NumberOfSongs = NumberOfSongsBefore;
        }

    }

}
