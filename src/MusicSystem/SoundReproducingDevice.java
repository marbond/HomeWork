package MusicSystem;

/**
 * Интерфейс, который описывает какие методы должны иметь объекты типа Звуковоспроизводящее устройство,
 * с методами: Вывод информации о том, что за устройство воспроизводит песню, ее исполнителя и название
 * */

public interface SoundReproducingDevice {

    void InformationOutput (SongCarrier SongCarrier);

}
