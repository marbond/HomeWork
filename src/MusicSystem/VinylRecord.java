package MusicSystem;

/**
 * Класс, который описывает объекты типа Виниловая пластинка,
 * с полями: Название Виниловой пластинки, Список песен, Кол-во песен
 * с методами: Получить название Виниловой пластинки, Добавить песню, Удалить песню,
 * Получить список песен, Поличить кол-во песен
 * */

public class VinylRecord implements SongCarrier {

    //Поля
    String NameVinylRecord;
    Song[] Songs = new Song[19];
    int NumberOfSongs = 0;

    //Конструктор
    VinylRecord (String NameVinylRecord){
        this.NameVinylRecord = NameVinylRecord;
    }

    //Метод Получить название Виниловой пластинки
    String getNameVinylRecord() {
        return this.NameVinylRecord;
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

        //Проверка Виниловой пластинки на заполненность
        if (this.NumberOfSongs == 20){
            System.out.println("Нельзя добавить песню, т.к. Виниловая пластинка полностью заполнена!");
        }

        //Добавление песни
        else {
            this.Songs[this.NumberOfSongs] = new Song(AuthorSong, NameSong);
            this.NumberOfSongs = this.NumberOfSongs + 1;
        }

    }

    //Метод Удалить песню
    public void DeleteSong(String AuthorSong, String NameSong) {
        System.out.println("Нельзя удалить песню с Виниловой пластинки");
    }

}
