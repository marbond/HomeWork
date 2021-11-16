package MusicSystem;

/**
 * Класс, который описывает объекты типа Виниловый проигрыватель
 * с полями: Название Винилового проигрывателя
 * с методами: Получить название Винилового проигрывателя,
 * Вывести информации о том, что за устройство воспроизводит песню, ее исполнителя и название
 * */

public class VinylPlayer implements SoundReproducingDevice {

    //Поля
    String NameVinylPlayer;

    //Конструктор
    VinylPlayer(String NameVinylPlayer) {
        this.NameVinylPlayer = NameVinylPlayer;
    }

    //Метод Получить название Винилового проигрывателя
    String getNameVinylPlayer() {
        return this.NameVinylPlayer;
    }

    //Метод Вывод информации о том, что за устройство воспроизводит песню, ее исполнителя и название
    //Входной параметр Звуковой носитель
    public void InformationOutput(SongCarrier SongCarrier) {

        //Проверка может ли устройство возпроизвести музыку с носителя
        if (SongCarrier instanceof VinylRecord) {

            //Получение списка песен с звукового носителя
            Song[] Songs = ((VinylRecord) SongCarrier).getSongs();

            //Получение информации о кол-ве песен на носителе
            int NumberOfSongs = ((VinylRecord) SongCarrier).getNumberOfSongs();

            //Вывод информации
            for (int j = 0; j < NumberOfSongs; j++) {
                System.out.println(this.NameVinylPlayer);
                System.out.println(Songs[j].AuthorSong);
                System.out.println(Songs[j].NameSong);
            }
        }

        //Если устройство не может воспроизвести музыку с требуемого носителя, то вывод соответствующего сообщения
        else{
            System.out.println("Устройство не может воспроизвести музыку с данного носителя :( :");
            System.out.println(((VinylRecord) SongCarrier).getNameVinylRecord());
        }

    }

}
