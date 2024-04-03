# Póker Kézértékelő Program Használata

Ez az alkalmazás egy póker kézértékelő program, amely képes értékelni és összesíteni különböző póker kezeket egy előre megadott bemeneti fájlból. Az alábbiakban található egy rövid összegzés arról, hogyan lehet használni ezt az alkalmazást:

## Bemeneti Fájl Elkészítése

Először is szükség van egy bemeneti fájlra, amely tartalmazza a különböző póker kezeket. A fájlnak minden sora egy kéz adatait tartalmazza. Az első sor a dealer kezét jelenti, a többi sor pedig a játékosok kezeit.

## Alkalmazás Futtatása

Az alkalmazást a következő módon kell futtatni a parancssorban vagy egy fejlesztői környezetben, ahol az első argumentum a bemeneti fájl neve, a második pedig a kimeneti fájl neve, ahova az eredmények kerülnek.

## Bemeneti Fájl Formátuma

A bemeneti fájlban minden sor egy kéz adatait tartalmazza. A kártyák jelölésére a következő jelöléseket használja: 2-9, T (10), J (Jumbo), Q (Dáma), K (Király), A (Ász), és a színek jelölésére: s (pikk), h (kör), d (káró), c (treff).

## Kimeneti Fájl Olvasása

A program futtatása után az eredmények a megadott kimeneti fájlban lesznek. Ez tartalmazni fogja minden játékos kézértékelését, valamint az összesítést az egyes kéztípusok számáról (pl. Four of a Kind, Full House, stb.).

Az alkalmazás az értékelést reguláris kifejezések segítségével végzi, melyek meghatározzák a különböző kéztípusokat, mint például Four of a Kind, Full House, Three of a Kind, stb. A kódban található egy hely, ahol a két pár (Two Pair) értékelése még nincs implementálva, így az értékelés jelenleg nem tartalmazza ezt a kéztípust.
