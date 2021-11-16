package MusicSystem;

/**
 * Интерфейс, который описывает какие методы должны иметь объекты типа Звуковой носитель,
 * с методами: Добавить песню на звуковой носитель, Удалить песню с звукового носителя,
 * Получить список песен, Получить кол-во песен
 * */

public interface SongCarrier {

    Song[] getSongs();

    int getNumberOfSongs();

    void addSong(String AuthorSong, String NameSong);

    void DeleteSong(String AuthorSong, String NameSong);

}
