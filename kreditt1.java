import java.util.Scanner;

public class kreditt1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String nama;
        int gaji, dp = 0, isidp = 0, angsur1 = 0, angsur2 = 0, angsur3 = 0, bunga1 = 0, bunga2 = 0, bunga3 = 0, agr,
                angsurtotal1 = 0, angsurtotal2 = 0, angsurtotal3 = 0, total = 0, strukAgr = 0;
        float persen = 0;

        System.out.println("-----KREDiT MA'RUF JAYA-----\n" +
                "Masukkan nama kreditur: ");
        nama = s.nextLine();

        System.out.println("Masukkan Gaji Pokok Kreditur: ");
        gaji = s.nextInt();

        System.out.println("1. Yamaha Vega: \t\tRp. 15.000.000\n"
                + "2. Yamaha Vixion: \t\tRp. 25.000.000\n"
                + "3. Honda CBR: \t\tRp. 20.000.000\n"
                + "4. Honda Supra: \t\tRp. 12.000.000\n"
                + "5. Suzuki Fu 150: \tRp. 20.000.000\n"
                + "6. Suzuki Nex: \t\tRp. 13.000.000\n" + "Pilih merek menggunakan nomor:");
        int opsi = s.nextInt();
        s.nextLine(); // Membersihkan buffer masukan

        switch (opsi) {
            case 1:
                dp = 15000000 / 2;
                System.out.println("DP Maksimal: " + dp + "\n" + "Masukkan nominal DP: ");
                isidp = s.nextInt();
                angsur1 += (15000000 - isidp) / 12;
                bunga1 += angsur1 * 0.1;
                angsurtotal1 += angsur1 + bunga1;
                angsur2 += (15000000 - isidp) / 24;
                bunga2 += angsur2 * 0.125;
                angsurtotal2 += angsur2 + bunga2;
                angsur3 += (15000000 - isidp) / 36;
                bunga3 += angsur3 * 0.15;
                angsurtotal3 += angsur3 + bunga3;

                do {
                    System.out.println("Gaji Pokok Anda: " + gaji
                            + "\n" + "1. 12 Bulan \t10% \tRp. " + angsurtotal1 + "\n"
                            + "2. 24 Bulan \t12.5% \tRp. " + angsurtotal2 + "\n"
                            + "3. 36 Bulan \t15% \tRp. " + angsurtotal3 + "\n"
                            + "Pilih opsi angsuran yang tersedia (Tidak boleh melebihi gaji pokok): ");
                    agr = s.nextInt();

                    if (agr == 1 && gaji >= angsurtotal1) {
                        strukAgr += angsurtotal1;
                    } else if (agr == 2) {
                        strukAgr += angsurtotal2;
                    } else if (agr == 3) {
                        strukAgr += angsurtotal3;
                    }

                } while (agr <= 3);
                System.out.println("-----STRUK KREDIT-----\n" + "Nama Kreditur: " + nama + "\n"
                        + "Gaji Pokok Kreditur: " + gaji + "\n"
                        + "Merk Motor: Yamaha Vega\n" + "Harga: Rp. 15.000.000\n"
                        + "DP: " + isidp + "\n" + "Nominal Angsuran: " + strukAgr + "\n"
                        + "Total Kredit dibayar:" + (dp + (strukAgr * 12)));
                break;
            case 2:
                // Case 2 - Yamaha Vixion
                // Perbaikan kode untuk case 2 sama dengan yang dilakukan pada case 1
                // ...
                break;
            // Cases untuk motor lainnya (3, 4, 5, 6) ikuti pola yang sama seperti case 1 dan 2

            default:
                System.out.println("Pilihan motor tidak valid.");
        }
    }
}
