# Heart-Attack-Probability-Rate-Prediction-Fuzzy-Logic

## Giriş
Bulanık mantık, belirsiz veya bulanık ifadelerle çalışabilen bir matematiksel modelleme ve kontrol yaklaşımıdır. Geleneksel mantık, kesin kural tabanlı ve kesin sınıflandırmalara dayanırken, bulanık mantık belirsizliği ele almak ve başa çıkmak için tasarlanmıştır.
Bu çalışmada, günlük uyku saati ve bir ayda yağlı yemek tüketilen gün sayısı üzerinde bulanık mantık kullanarak bir model oluşturulmuştur. JFuzzy kütüphanesi, bu değişkenler arasındaki ilişkiyi tanımlamak için kullanılmıştır.
Günlük uyku süresinin ve bir ayda yağlı yemek tüketilen gün sayısının kalp krizine etkisi internetten çeşitli kaynaklardan araştırılmıştır. Günlük uyku süresi ile ilgili net bilgiler bulunsa da bir ayda yenen yağlı yemek gün sayısı ile ilgili somut bir çalışma bulunamamıştır. Araştırmalar sonucunda elde edilen bilgiler üyelik fonksiyonlarını oluşturmak için kullanılmıştır.
Bu projeyle birlikte bulanık mantık ile ilgili temel konularda bilgi sahibi olunmuş, küçük de olsa bir uygulama yapılmıştır.

## Adımlar

### 1. Veri Toplama ve Analiz

İlk adım olarak, uyku saati ve yağlı yemek tüketilen gün sayısı gibi değişkenlerin kalp krizi riski üzerindeki etkileri araştırılıp, üyelik fonksiyonlarının sınır değerleri ile ilgili bilgi sahibi olunması amaçlanacaktır.

### 2. FCL Dilinde Input ve Output Değişkenlerinin Oluşturulması

Fuzzy Logic Controller (FCL) dilinde, proje için gerekli olan input (giriş) ve output (çıkış) değişkenleri tanımlanacak ve bu değişkenlerin sistemle olan ilişkileri belirlenecektir.

### 3. FUZZYFICATION ve DEFUZZYFICATION İşlemleri

Belirlenen input değişkenleri, uygun fuzzyfication işlemlerinden geçirilecek ve ardından oluşturulan kurallar doğrultusunda defuzzyfication işlemleri uygulanacaktır.

### 4. Çıktıların Görselleştirilmesi ve Durulama Methodlarının Karşılaştırılması

Son olarak, elde edilen çıktılar görselleştirilecek ve farklı durulama (defuzzification) yöntemleri karşılaştırılacaktır. Bu adım, elde edilen sonuçları daha anlaşılır kılmak ve sistem performansını değerlendirmek adına önemlidir.


## Uyku Saati Üyelik Fonksiyonu

Uyku saatinin kalp krizi riski üzerindeki etkisini belirlemek için, yetişkin bireylerde yapılan araştırmalardan elde ettiğimiz bilgileri kullanıyoruz. Araştırmalar sonucunda uyku süresi ve kalp sağlığı arasında doğrudan bir ilişki olduğunu gözlemledik. Aşağıda uyku saati için oluşturulan üyelik fonksiyonu:

- **Kısa Uyku (0-6 saat):** Kalp krizi riski yüksek. (Kaynak: [American College of Cardiology](kaynak_linki) ve "Sleep Duration Predicts Cardiovascular Outcomes: A Systematic Review and Meta-analysis of Prospective Studies" makalesi)

- **Orta Uyku (6-8 saat):** Kalp krizi riski düşük. (Referans: [American College of Cardiology](kaynak_linki) ve "Sleep Duration Predicts Cardiovascular Outcomes: A Systematic Review and Meta-analysis of Prospective Studies" makalesi)

- **Uzun Uyku (8-12 saat):** Kalp krizi riski yine yüksek. (Kaynak: [American College of Cardiology](kaynak_linki) ve "Sleep Duration Predicts Cardiovascular Outcomes: A Systematic Review and Meta-analysis of Prospective Studies" makalesi)

## Yağlı Yemek Gün Sayısı Üyelik Fonksiyonu

Bir ay içinde yağlı yemek yenen gün sayısının kalp krizi riski üzerindeki etkisini belirlemek için, beslenme alışkanlıklarının genel etkisini değerlendiren araştırmalardan elde ettiğimiz bilgileri kullanıyoruz. Aşağıda yağlı yemek gün sayısı için oluşturulan üyelik fonksiyonu:

- **Düşük Yağlı Yemek Gün Sayısı (0-10 gün):** Kalp krizi riski düşük. (Referans: Beslenme alışkanlıkları üzerine genel araştırmalar)

- **Orta Yağlı Yemek Gün Sayısı (10-20 gün):** Kalp krizi riski orta. (Referans: Beslenme alışkanlıkları üzerine genel araştırmalar)

- **Yüksek Yağlı Yemek Gün Sayısı (20-30 gün):** Kalp krizi riski yüksek. (Referans: Beslenme alışkanlıkları üzerine genel araştırmalar)

![image](https://github.com/BeytullahYayla/Heart-Attack-Probability-Rate-Prediction-Fuzzy-Logic/assets/78471151/23cb0877-8788-4c31-8374-3dc7016f7970)

## Input Değerleri

### 1. Uyku Süresi (`sleepDuration`)

Kullanıcıdan alınan uyku süresi, kişinin günlük ortalama uyku süresini ifade eder. Bu değer REAL tipindedir ve aşağıdaki üyelik fonksiyonları ile tanımlanır:

- **Kısa Uyku (ShortSleep):** 0-6 saat arası
- **Orta Uyku (MediumSleep):** 6-8 saat arası
- **Uzun Uyku (LongSleep):** 8-12 saat arası

### 2. Aylık Yağlı Yemek Gün Sayısı (`eatenFattyFood`)

Kullanıcıdan alınan bu değer, bir ay içinde tüketilen yağlı yemek gün sayısını ifade eder. Bu değer de REAL tipindedir ve aşağıdaki üyelik fonksiyonları ile tanımlanır:

- **Düşük Yağlı Yemek Gün Sayısı (LowFattyFood):** 0-10 gün arası
- **Orta Yağlı Yemek Gün Sayısı (ModerateFattyFood):** 10-20 gün arası
- **Yüksek Yağlı Yemek Gün Sayısı (HighFattyFood):** 20-30 gün arası

## Output Değeri

Kalp krizi olasılığı (`heartAttackProbability`) REAL tipindedir ve aşağıdaki üyelik fonksiyonları ile tanımlanır:

- **Düşük Risk (LowRisk):** 0-30 birim arası düşük risk
- **Orta Risk (MediumRisk):** 30-60 birim arası orta risk
- **Yüksek Risk (HighRisk):** 60-100 birim arası yüksek risk

Bu üyelik fonksiyonları, FCL tarafından kullanılarak çıkarım işlemleri yapılacak ve sonuç olarak bir kalp krizi olasılığı değeri elde edilecektir.

![image](https://github.com/BeytullahYayla/Heart-Attack-Probability-Rate-Prediction-Fuzzy-Logic/assets/78471151/200d8f28-96e2-4a1c-83ac-61daaa96feb7)


# FUZZYFICATION ve DEFUZZYFICATION İşlemleri

Bu bölümde, bulanık mantık kontrollerinde kullanılacak olan Fuzzyfication (Bulanıklaştırma) ve Defuzzyfication (Durulama) işlemlerini açıklayacağım.

## FUZZYFICATION (Bulanıklaştırma)

### 1. Uyku Süresi (`sleepDuration`)

Uyku süresi değişkeni için üyelik fonksiyonları şu şekildedir:

- **Less (Az):** Uyku süresi 0-6 saat arasında. Üyelik değeri 5 saate kadar tam üyedir, sonrasında 6. saatten itibaren 0 olur.
- **Normal:** Uyku süresi 5-9 saat arasında. Üyelik değeri 5 saatten başlayıp 6. ve 8. saate kadar tam üye olur, sonrasında lineer olarak azalır.
- **More (Fazla):** Uyku süresi 8-12 saat arasında. Üyelik değeri 8 saatten başlayıp 10. saatte  tam üye olur, sonrasında tam üye olur.

![image](https://github.com/BeytullahYayla/Heart-Attack-Probability-Rate-Prediction-Fuzzy-Logic/assets/78471151/42bd329b-3265-4886-a99b-d93804bf7f27)


### 2. Aylık Yağlı Yemek Gün Sayısı (`eatenFattyFood`)

Yağlı yemek gün sayısı değişkeni için üyelik fonksiyonları şu şekildedir:

- **Rare (Ara sıra):** Yağlı yemek gün sayısı 0-9 arasında. Üyelik değeri 5 güne kadar tam üyedir, sonrasında lineer olarak azalarak 9.saatte 0 olur.
- **Often (Sık sık):** Yağlı yemek gün sayısı 5-19 arasında. Üyelik değeri 5 günden başlayıp 12. güne kadar lineer şekilde artar ve 12.gün tam üye olur, sonrasında lineer olarak azalır. 19.günde üyelik değeri 0 olur.
- **MoreOften (Daha sık):** Yağlı yemek gün sayısı 15-30 arasında. Üyelik değeri 15 günden başlayıp 17.güne lineer artar, 17.gündeve sonrasında tam üyedir.

![image](https://github.com/BeytullahYayla/Heart-Attack-Probability-Rate-Prediction-Fuzzy-Logic/assets/78471151/a3e4772d-f85b-413b-b596-3408e382e5b2)


## DEFUZZYFICATION (Durulama)

Kalp krizi olasılığı (`heartAttackProbability`) değeri, üyelik fonksiyonlarından elde edilen bulanık çıktıyı sayısal bir değere dönüştürmek için kullanılır. Bu durulama işlemi şu şekildedir:

- **Low Risk (Düşük Risk):** 0-20 arası birimlerde düşük risk.
- **Medium Risk (Orta Risk):** 15-55 arası birimlerde orta risk.
- **High Risk (Yüksek Risk):** 50-100 arası birimlerde yüksek risk.

Bu değerler, belirlenen üyelik fonksiyonları ve çıkarım kuralları kullanılarak elde edilir ve projenin sonucunu sayısal bir şekilde ifade eder.

![image](https://github.com/BeytullahYayla/Heart-Attack-Probability-Rate-Prediction-Fuzzy-Logic/assets/78471151/8b26ffff-2c89-4e5b-8a0d-254695db56f3)

## ÇIKTILAR
Örnek olarak verilen input değerlerine karşılık elde edilen output değerleri aşağıdaki resimlerde verilmiştir. İlk olarak günde 6 saat uyuyan ve ayda 7 gün yağlı yemek yiyen birinin kalp krizi geçirme olasılığına bakalım.

![image](https://github.com/BeytullahYayla/Heart-Attack-Probability-Rate-Prediction-Fuzzy-Logic/assets/78471151/9a427c6a-5715-4135-975e-83f0a91bdc98)

Oluşan taralı alan aşağıdaki şekilde olacaktır

![image](https://github.com/BeytullahYayla/Heart-Attack-Probability-Rate-Prediction-Fuzzy-Logic/assets/78471151/fcdab70f-2d0a-44d4-99e9-fd49170bb39f)

Burada devreye durulama methodları girmektedir. Durulama methodlarını kullanarak taralı alandan output değerimizi alabiliyoruz. Ben çalışmamda 2 farklı durulama methodu kullandım ve bu sonuçları aşağıdaki gibi karşılaştırdım.

### COG(Center of Gravity) methodu:

Taralı alanın ağırlık merkezindeki değeri döndürür. Yine uyku saati için 6, yağlı yenen gün sayısı için 7 değerlerini kullandığımızda kalp krizi değerini %23 olarak elde ediyoruz:

![image](https://github.com/BeytullahYayla/Heart-Attack-Probability-Rate-Prediction-Fuzzy-Logic/assets/78471151/64c0648f-741b-414c-b057-986c7ac93b3b)

### RM (Right Maximum) methodu:

Bu durulama methodu taralı alandaki tepe noktası değerinin en sağ noktasındaki değeri döndürür. Aynı input değerlerini kullandığımızda kalp krizi riskinin %15 olduğunu görüyoruz.

![image](https://github.com/BeytullahYayla/Heart-Attack-Probability-Rate-Prediction-Fuzzy-Logic/assets/78471151/d15c3180-a89e-490f-86df-ca5408205dd7)

Her iki yöntem de farklı kullanım durumlarına ve sistem gereksinimlerine göre tercih edilebilir. Right Maximum, daha basit ve doğrudan bir yaklaşım sunarken, Center of Gravity daha fazla matematiksel hesap içerir ancak daha hassas sonuçlar verebilir. Bu yüzden projede COG methodunu kullanmaya karar verdim.



## Referanslar

1. **Too Much, Too Little Sleep Linked to Elevated Heart Risks in People Free from Disease**
   - [American College of Cardiology](https://www.acc.org/about-acc/press-releases/2021/05/04/19/47/too-much-too-little-sleep-linked-to-elevated-heart-risks-in-people-free-from-disease)

2. **Sleep Duration Predicts Cardiovascular Outcomes: A Systematic Review and Meta-analysis of Prospective Studies**
   - [European Heart Journal Advance Access](https://academic.oup.com/eurheartj/advance-article/doi/10.1093/eurheartj/ehq391/558878)

3. **Kardiyovasküler Sistem Hastalıklarının Risk Faktörleri Üzerine Beslenme Durumunun Etkisi**
   - [Journal of Health Services and Education](https://www.jhse-online.com/articles/)



