package UAS;

import java.util.Scanner;

public class TugasBesar {
    static Scanner scanner = new Scanner(System.in);
    static String name;
    static int retryCount = 0;
    static final int MAX_RETRY = 3;
    static char[] answers;

    // test push

    public static void main(String[] args) {

        System.out.print("Masukkan nama : ");
        name = scanner.nextLine();

        if(name.isEmpty()) {
            System.out.println("kamu tidak isi nama mu! 😡");
        } else {
            menu(name);
        }

        line();

    }

    static void line() {
        System.out.println("================================================");
    }

    static boolean confirmExit() {
        System.out.print("Yakin ingin keluar? (Y/N): ");
        String c = scanner.nextLine();
        return c.equalsIgnoreCase("Y");
    }

    static void menu(String name) {

        line();

        System.out.println("Hai rakyat bernama \"" + name + "\" " + "Selamat datang di Tes Kepribadian dengan Kokologi");
        System.out.println("1. Apa itu Kokologi?");
        System.out.println("2. Mulai Test!");
        System.out.println("3. Keluar program");
        System.out.print("ketik 1/2/3 untuk memilih: ");
        int option = safeIntInput(1, 3);

        switch (option) {
            case 1:
                aboutCocology();
                break;
            case 2:
                toTest();
                break;
            case 3:
                if (confirmExit()) {
                    System.out.println("Program selesai.");
                    System.exit(0);
                }
                menu(name);
                return;

            default:
                System.out.println("Pilihan mu salah!");
                menu(name);
        }
    }

    static void aboutCocology() {

        line();

        System.out.println("Apa yang ingin kamu tau tentang Kokologi?");
        System.out.println("0. Kembali ke menu utama");
        System.out.println("1. Apa itu Kokologi");
        System.out.println("2. Jenis atau bentuk Tes Kokologi");
        System.out.println("3. Mengapa Kokologi ada dan digunakan");
        System.out.print("ketik 0/1/2/3 untuk memilih: ");
        int about = safeIntInput(1, 3);

        switch (about) {
            case 0:
                System.out.println("Keluar...");
                menu(name);
                return;
            case 1:
                System.out.println("Kokologi itu permainan psikologi seru dari Jepang yang bisa ungkap kepribadian atau pikiran tersembunyi lewat imajinasi sederhana. Berasal dari kata \"kokoro\" (pikiran/perasaan dalam bahasa Jepang) + \"logia\" (ilmu dalam bahasa Yunani).\n" +
                        " Diciptakan oleh Tadahiko Nagao dan Isamu Saito di buku Kokology tahun 1998. Bukan tes ilmiah beneran, tapi fun buat refleksi diri!\n" +
                        "Lebih sederhananya +Kokologi adalah metode tes kepribadian sederhana yang menggunakan pertanyaan tidak langsung.\n" +
                        "Jawaban yang dipilih tidak dinilai benar atau salah, tetapi digunakan untuk melihat kecenderungan cara berpikir, emosi, dan interaksi sosial seseorang.");;
                break;
            case 2:
                System.out.println("Tes kokologi biasanya berbentuk pertanyaan situasional, pilihan simbol, atau reaksi spontan terhadap suatu kondisi.\n" +
                        "Dalam program ini, kokologi disajikan dalam bentuk pertanyaan pilihan ganda untuk memudahkan proses penilaian secara logis.");;
                break;
            case 3:
                System.out.println("Kokologi digunakan sebagai alat refleksi diri yang sederhana dan mudah dipahami.\n" +
                        "Tes ini tidak bertujuan untuk mendiagnosis, tetapi membantu pengguna mengenali kecenderungan diri melalui pilihan yang dibuat.");;
                break;
            default:
                aboutCocology();
                return;
        }

        recheck("aboutcocology");
    }

    static int safeIntInput(int min, int max) {
        while (true) {
            if (scanner.hasNextInt()) {
                int val = scanner.nextInt();
                scanner.nextLine(); // bersihin newline
                if (val >= min && val <= max) {
                    return val;
                }
            } else {
                scanner.nextLine();
            }
            System.out.print("Input tidak valid. Masukkan angka " + min + "-" + max + ": ");
        }
    }

    static void recheck(String state) {
        line();
        System.out.print("Recheck (Y/N): ");
        String opt = scanner.nextLine();

        if (opt.equalsIgnoreCase("Y")) {
            retryCount = 0;
            if (state.equalsIgnoreCase("aboutcocology")) {
                aboutCocology();
            } else {
                toTest();
            }
        } else if (opt.equalsIgnoreCase("N")) {
            retryCount = 0;
            menu(name);
        } else {
            retryCount++;
            if (retryCount > MAX_RETRY) {
                System.out.println("Batas percobaan tercapai.");
                retryCount = 0;
                menu(name);
            } else {
                System.out.println("Input salah. Coba lagi.");
                recheck(state);
            }
        }
    }

    static int logicScore = 0;
    static int socialScore = 0;
    static int emotionScore = 0;

    static void toTest() {

        logicScore = 0;
        socialScore = 0;
        emotionScore = 0;

        line();
        System.out.println("TES KEPRIBADIAN KOKOLOGI");
        System.out.println("Jawablah setiap pertanyaan dengan jujur.");
        System.out.println("Tidak ada jawaban benar atau salah.");
        System.out.println("A / B / C");
        line();

        String[] questions = {
                "1. Kamu sedang mengerjakan tugas kelompok dengan deadline mepet.\n" +
                        "Salah satu anggota tiba-tiba tidak bisa dihubungi dan bagian tugasnya belum selesai.\n" +
                        "Situasi ini membuat kelompokmu terancam terlambat mengumpulkan tugas.\n" +
                        "\n" +
                        "Apa yang paling mungkin kamu lakukan?\n" +
                        "A. Mengatur ulang pembagian tugas dan menyusun rencana agar pekerjaan tetap selesai tepat waktu\n" +
                        "B. Menghubungi anggota lain dan membahas solusi bersama\n" +
                        "C. Merasa kesal dan cemas, lalu menunggu suasana hati membaik sebelum bertindak",

                "2. Kamu mendapat kritik dari seseorang tentang hasil kerja yang sudah kamu usahakan semaksimal mungkin.\n" +
                        "Kritik tersebut disampaikan di depan orang lain.\n" +
                        "\n" +
                        "Bagaimana reaksimu?\n" +
                        "A. Mendengarkan kritik tersebut dan menilai apakah masuk akal\n" +
                        "B. Memperhatikan cara penyampaian dan niat orang yang memberi kritik\n" +
                        "C. Merasa tersinggung dan memikirkan perasaanmu terlebih dahulu",

                "3. Saat berada di lingkungan baru, kamu tidak mengenal siapa pun.\n" +
                        "Semua orang terlihat sibuk dengan aktivitas masing-masing.\n" +
                        "\n" +
                        "Apa yang biasanya kamu lakukan?\n" +
                        "A. Mengamati situasi terlebih dahulu sebelum bertindak\n" +
                        "B. Mencoba menyapa dan berkenalan dengan beberapa orang\n" +
                        "C. Menyesuaikan diri perlahan sambil memperhatikan perasaan sendiri",

                "4. Kamu harus mengambil keputusan penting yang akan memengaruhi masa depanmu,\n" +
                        "tetapi informasi yang kamu miliki belum sepenuhnya lengkap.\n" +
                        "\n" +
                        "Apa pendekatanmu?\n" +
                        "A. Mengumpulkan data tambahan dan menganalisis risiko\n" +
                        "B. Berdiskusi dengan orang-orang yang kamu percaya\n" +
                        "C. Mengikuti kata hati yang paling terasa benar",

                "5. Seorang teman dekat sedang mengalami masalah pribadi dan terlihat sangat tertekan, tetapi tidak secara langsung meminta bantuan.\n" +
                        "\n" +
                        "Apa yang kamu lakukan?\n" +
                        "A. Memberikan saran yang rasional dan solusi konkret\n" +
                        "B. Menemani dan mendengarkan ceritanya\n" +
                        "C. Ikut merasakan kesedihannya dan menunjukkan empati",

                "6. Kamu gagal mencapai target yang sudah lama kamu rencanakan, padahal kamu merasa sudah berusaha maksimal.\n" +
                        "\n" +
                        "Reaksi pertamamu adalah...\n" +
                        "A. Mengevaluasi kesalahan dan menyusun strategi baru\n" +
                        "B. Menceritakan pengalaman tersebut kepada orang lain\n" +
                        "C. Merasa kecewa dan butuh waktu untuk menenangkan diri",

                "7. Dalam sebuah diskusi, pendapatmu berbeda dengan mayoritas orang dan berpotensi menimbulkan perdebatan.\n" +
                        "\n" +
                        "Apa yang kamu lakukan?\n" +
                        "A. Menyampaikan argumen berdasarkan logika dan fakta\n" +
                        "B. Menyesuaikan cara bicara agar tidak menyinggung orang lain\n" +
                        "C. Menimbang perasaanmu sebelum memutuskan untuk berbicara",

                "8. Kamu berada dalam situasi penuh tekanan dan harus menyelesaikan banyak hal sekaligus dalam waktu singkat.\n" +
                        "\n" +
                        "Bagaimana kamu menghadapinya?\n" +
                        "A. Menyusun prioritas dan fokus satu per satu\n" +
                        "B. Mencari bantuan atau dukungan dari sekitar\n" +
                        "C. Merasa stres dan mencoba menenangkan emosi terlebih dahulu",

                "9. Ketika menghadapi konflik antara dua orang yang kamu kenal, kamu berada di posisi netral.\n" +
                        "\n" +
                        "Apa sikapmu?\n" +
                        "A. Menilai masalah dari sudut pandang yang objektif\n" +
                        "B. Mencoba menjadi penengah agar kedua pihak berdamai\n" +
                        "C. Merasa tidak nyaman dan terbawa suasana konflik",

                "10. Kamu harus memilih antara dua pilihan yang sama-sama menarik, tetapi memiliki risiko yang berbeda.\n" +
                        "\n" +
                        "Apa yang paling memengaruhi keputusanmu?\n" +
                        "A. Pertimbangan logis dan konsekuensi jangka panjang\n" +
                        "B. Dampak pilihan tersebut terhadap orang lain\n" +
                        "C. Perasaan yang paling kuat saat itu"
        };

        answers = new char[questions.length];

        for (int i = 0; i < questions.length; i++) {
            while (true) {
                line();
                System.out.println(questions[i]);
                System.out.print("Jawaban kamu (A/B/C): ");
                String input = scanner.nextLine().toUpperCase();

                if (input.length() != 1) {
                    System.out.println("Masukkan A, B, atau C!");
                    continue;
                }

                char choice = input.charAt(0);
                answers[i] = choice;

                switch (choice) {
                    case 'A' -> logicScore += 2;
                    case 'B' -> socialScore += 2;
                    case 'C' -> emotionScore += 2;
                    default -> {
                        System.out.println("Input tidak valid!");
                        continue;
                    }
                }
                break;
            }
        }

        showResults();
        line();
        showAnswerHistory();
    }

    static void showAnswerHistory() {
        System.out.println("Riwayat Jawaban:");
        for (int i = 0; i < answers.length; i++) {
            System.out.println("Soal " + (i + 1) + ": " + answers[i]);
        }
    }

    static void showResults() {
        line();
        System.out.println("HASIL TES KEPRIBADIAN KOKOLOGI");
        line();


        int totalScore = logicScore + socialScore + emotionScore;

        System.out.println("Rekap Skor:");
        System.out.println("Logika  : " + logicScore);
        System.out.println("Sosial  : " + socialScore);
        System.out.println("Emosi   : " + emotionScore);
        System.out.println("Total   : " + totalScore);

        line();

        String type = "";
        String description = "";

        if (logicScore > socialScore && logicScore > emotionScore) {
            type = "RASIONAL";
            description =
                    "Kamu cenderung berpikir secara logis dan objektif.\n" +
                            "Dalam menghadapi masalah, kamu lebih mengandalkan analisis dan fakta.\n" +
                            "Keputusan yang kamu ambil biasanya berdasarkan pertimbangan yang matang.";

        } else if (socialScore > logicScore && socialScore > emotionScore) {
            type = "SOSIAL";
            description =
                    "Kamu memiliki kemampuan berinteraksi dan bekerja sama dengan orang lain.\n" +
                            "Pendapat dan perasaan orang di sekitarmu menjadi pertimbangan penting.\n" +
                            "Kamu nyaman berada dalam lingkungan sosial.";

        } else if (emotionScore > logicScore && emotionScore > socialScore) {
            type = "EMOSIONAL";
            description =
                    "Kamu sangat peka terhadap perasaan diri sendiri dan orang lain.\n" +
                            "Emosi sering memengaruhi cara kamu mengambil keputusan.\n" +
                            "Empati menjadi kekuatan utama dalam kepribadianmu.";

        } else if(logicScore == socialScore && logicScore > emotionScore) {
            type = "LOGIS SOSIAL";
            description =
                    "Kamu memiliki keseimbangan antara pemikiran logis dan kepedulian sosial.\n" +
                            "Dalam mengambil keputusan, kamu mempertimbangkan fakta serta dampaknya terhadap orang lain.\n" +
                            "Kamu mampu berpikir rasional tanpa mengabaikan nilai empati dan kerja sama.";

        } else {
            type = "SEIMBANG";
            description =
                    "Kamu memiliki keseimbangan antara logika, sosial, dan emosi.\n" +
                            "Cara berpikirmu fleksibel dan mudah menyesuaikan diri dengan situasi.\n" +
                            "Kamu dapat melihat masalah dari berbagai sudut pandang.";
        }

        System.out.println("Tipe Kepribadian Kamu: " + type);
        line();
        System.out.println(description);
        line();

        recheck("totest");
    }

}
