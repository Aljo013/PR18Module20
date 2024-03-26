Deskripsi Projek : Merupakan Projek PR 18 Modul 20 Membuat kerangka otomatis API menggunakan Framework Cucumber
Cara Menjalankan Projek : Membuka file api.feature, lalu melakukan run test pada file tersebut
Page Object Model :
1. package features berisi file api.feature.
   a. api.feature : merupakan file yang digunakan untuk melakukan run projek. didalamnya terdapat alur dari tiap scenario dan step step menjalankan scenarionya.
2. package helper berisi file pendukung.
   a. JsonSchemaData yang digunakan untuk mendefinisikan struktur, format, dan validasi data dalam format JSON.
   b. Endpoint.java berisi url yang akan digunakan
   c. Models.java berisi authorization key, dan respon respon yang akan digunakan, seperi  getlist, delete, post, update, dll.
   d. Utility.java berisi fungsi untuk mengambil email secara random dikarenakan pada kasus ini email tidak boleh sama tiap usernya, dan juga fungsi memanggil file JSON yang     ada.
3. package pages, berisi file ApiPage.java
   a. ApiPage.java merupakan file yang digunakan untuk memproses step tiap scenarionya.
4. package stepdef
   a. ApiSetp.java merupakan file untuk memanggil fungsi-fungsi pada ApiPage.java, agak lebih rapih.
Hasil Projek :
1. GET_LIST_USERS :
![alt text](https://github.com/Aljo013/PR18Module20/result/DELETE_USER.png?raw=true)
