package MusicSystem;

/**
 * Класс, который описывает тип объектов Песня,
 * с полями: Название, Автор
 * и методами: Получить название,  Получить автора
 * */

public class Song {

    String AuthorSong;
    String NameSong;

    Song (String AuthorSong, String NameSong){
        this.AuthorSong = AuthorSong;
        this.NameSong = NameSong;
    }

    String getNameSong() {
        return this.NameSong;
    }

    String getAuthorSong() {
        return this.AuthorSong;
    }

}
