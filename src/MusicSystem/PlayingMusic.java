package MusicSystem;

/**
 * @version 2
 * @author Марина Бондарчук
 * */

public class PlayingMusic {
        public static void main(String[] args) {

            //Создание объекта типа Флеш-карта
            FlashCard flashCard = new FlashCard("Флешка1");

            //Добавление музыки на Флеш-карту
            flashCard.addSong("Би2", "Варвара");
            flashCard.addSong("Би2", "Она");
            flashCard.addSong("Би2", "Полковнику никто не пишет");

            //Удаление музыки с Флеш-карты
            flashCard.DeleteSong("Би2", "Её глаза");

            //Создание объекта типа Универсальный плеер
            UniversalPlayer UniversalPlayer = new UniversalPlayer("Camry CR1114");

            //Вывод информации о воспроизводимой музыке
            UniversalPlayer.InformationOutput(flashCard);

            //Создание объекта типа CD-диск
            SongCarrier SongCarrier = new CD("Сборник лучших песен Ирины Алегровой");

            //Добавление музыки на CD-диск
            SongCarrier.addSong("Ирина Алегрова", "Привет, Андрей");

            //Создание объекта типа CD-плеер
            SoundReproducingDevice SoundReproducingDevice = new CD("Philips EXP2550");

            //Вывод информации о воспроизводимой музыке
            SoundReproducingDevice.InformationOutput(SongCarrier);

            //Создание объекта типа Виниловая пластинка
            VinylRecord VinylRecord = new VinylRecord("Дискоклуб-12");

            //Добавление музыки на Виниловую пластинку
            VinylRecord.addSong("Веселые ребята", "Вот и все");

            //Удаление музыки с Виниловой пластинки
            VinylRecord.DeleteSong("Веселые ребята", "Вот и все");

            //Создание объекта типа CD-плеер
            VinylPlayer  VinylPlayer  = new VinylPlayer ("Ritmix LP-280");

            //Вывод информации о воспроизводимой музыке
            VinylPlayer.InformationOutput(VinylRecord);

        }
}
