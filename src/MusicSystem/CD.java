package MusicSystem;

/**
 * Класс, который описывает объекты типа CD-диск и CD-плеер (в зависимости от родительского интерфейса)
 * с полями: Название CD, Список песен, Кол-во песен
 * с методами: Получить название CD, Добавить песню, Удалить песню,
 * Получить список песен, Поличить кол-во песен,
 * Вывести информации о том, что за устройство воспроизводит песню, ее исполнителя и название
 * */

public class CD implements SongCarrier, SoundReproducingDevice {

    //Поля
    String NameCD;
    Song[] Songs = new Song[50];
    int NumberOfSongs = 0;

    //Конструктор
    CD (String NameCD){
        this.NameCD = NameCD;
    }

    //Метод Получить название CD
    String getNameCD() {
        return this.NameCD;
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

        //Проверка CD на заполненность
        if (this.NumberOfSongs == 50){
            System.out.println("Нельзя добавить песню на CD-диск, так как он полностью заполнен!");
        }

        //Добавление песни
        else {
            this.Songs[this.NumberOfSongs] = new Song(AuthorSong, NameSong);
            this.NumberOfSongs = this.NumberOfSongs + 1;
        }

    }

    //Метод Удалить песню
    public void DeleteSong(String AuthorSong, String NameSong) {
        System.out.println("Нельзя удалить песню с CD-диска");
    }

    //Метод Вывести информации о том, что за устройство воспроизводит песню, ее исполнителя и название
    //Входной параметр Звуковой носитель
    public void InformationOutput(SongCarrier SongCarrier) {

        //Проверка может ли устройство возпроизвести музыку с носителя
        if (SongCarrier instanceof CD) {

            //Получение списка песен с звукового носителя
            Song[] Songs = ((CD) SongCarrier).getSongs();

            //Получение информации о кол-ве песен на носителе
            int NumberOfSongs = ((CD) SongCarrier).getNumberOfSongs();

            //Вывод информации
            for (int j = 0; j < NumberOfSongs; j++) {
                System.out.println(this.NameCD);
                System.out.println(Songs[j].AuthorSong);
                System.out.println(Songs[j].NameSong);
            }
        }

        //Если устройство не может воспроизвести музыку с требуемого носителя, то вывод соответствующего сообщения
        else{
            System.out.println("Устройство не может воспроизвести музыку с данного носителя :( :");
            System.out.println(((CD) SongCarrier).getNameCD());
        }

    }

}
