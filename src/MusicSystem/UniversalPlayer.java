package MusicSystem;

/**
 * Класс, который описывает объекты типа Универсальный плеер
 * с полями: Название Универсального плеера
 * с методами: Получить название Универсального плеера,
 * Вывести информации о том, что за устройство воспроизводит песню, ее исполнителя и название
 * */

public class UniversalPlayer implements SoundReproducingDevice{

    //Поля
    String NameUniversalPlayer;

    //Конструктор
    UniversalPlayer(String NameUniversalPlayer) {
        this.NameUniversalPlayer = NameUniversalPlayer;
    }

    //Метод Вывод информации о том, что за устройство воспроизводит песню, ее исполнителя и название
    //Входной параметр Звуковой носитель
    public void InformationOutput(SongCarrier SongCarrier) {

            //Получение списка песен с звукового носителя
            Song[] Songs = SongCarrier.getSongs();

            //Получение информации о кол-ве песен на носителе
            int NumberOfSongs = SongCarrier.getNumberOfSongs();

            //Вывод информации
            for (int j = 0; j < NumberOfSongs; j++) {
                System.out.println(this.NameUniversalPlayer);
                System.out.println(Songs[j].AuthorSong);
                System.out.println(Songs[j].NameSong);
            }
        }

    }


