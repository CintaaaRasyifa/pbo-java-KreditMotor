package kreditjava;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class k4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan nama kreditur: ");
        String namaKreditur = scanner.nextLine();

        System.out.print("Masukkan gaji pokok: ");
        double gajiPokok = scanner.nextDouble();

        System.out.print("Masukkan kategori merk motor (1=Yamaha, 2=Honda, 3=Suzuki): ");
        int kategoriMerk = scanner.nextInt();

        int hargaMotor = 0;
        String merkMotor = "";

        // ... kode untuk pilihan merk motor sebelumnya ...
        switch (kategoriMerk) {
            case 1:
                System.out.println("Pilihan Merk Yamaha:");
                System.out.println("1. Vega (Harga: 15jt)");
                System.out.println("2. Vixion (Harga: 25jt)");
                System.out.print("Masukkan pilihan merk Yamaha (1/2): ");
                int pilihanYamaha = scanner.nextInt();

                if (pilihanYamaha == 1) {
                    merkMotor = "Yamaha Vega";
                    hargaMotor = 15000000;
                } else if (pilihanYamaha == 2) {
                    merkMotor = "Yamaha Vixion";
                    hargaMotor = 25000000;
                } else {
                    System.out.println("Pilihan tidak valid.");
                    return;
                }
                break;

            case 2:
                System.out.println("Pilihan Merk Honda:");
                System.out.println("1. CBR (Harga: 20jt)");
                System.out.println("2. Supra (Harga: 12jt)");
                System.out.print("Masukkan pilihan merk Honda (1/2): ");
                int pilihanHonda = scanner.nextInt();

                if (pilihanHonda == 1) {
                    merkMotor = "Honda CBR";
                    hargaMotor = 20000000;
                } else if (pilihanHonda == 2) {
                    merkMotor = "Honda Supra";
                    hargaMotor = 12000000;
                } else {
                    System.out.println("Pilihan tidak valid.");
                    return;
                }
                break;

            case 3:
                System.out.println("Pilihan Merk Suzuki:");
                System.out.println("1. FU 150 (Harga: 20jt)");
                System.out.println("2. Nex (Harga: 13jt)");
                System.out.print("Masukkan pilihan merk Suzuki (1/2): ");
                int pilihanSuzuki = scanner.nextInt();

                if (pilihanSuzuki == 1) {
                    merkMotor = "Suzuki FU 150";
                    hargaMotor = 20000000;
                } else if (pilihanSuzuki == 2) {
                    merkMotor = "Suzuki Nex";
                    hargaMotor = 13000000;
                } else {
                    System.out.println("Pilihan tidak valid.");
                    return;
                }
                break;

            default:
                System.out.println("Kategori merk tidak valid.");
                return;
        }


        int dpMax = hargaMotor / 2;
        int dp = 0;
        while (dp <= 0 || dp > dpMax) {
            System.out.print("Masukkan jumlah DP (maksimum " + formatCurrency(dpMax) + "): ");
            dp = scanner.nextInt();
            if (dp > dpMax) {
                System.out.println("DP melebihi batas maksimum.");
            }
        }

        int jumlahBulan = 0;
        double bunga = 0;

       
System.out.println("Pilihan Tenor:");
System.out.println("1. 12 Bulan (Bunga: 10%)");
System.out.println("2. 24 Bulan (Bunga: 12%)");
System.out.println("3. 36 Bulan (Bunga: 24%)");
System.out.println("4. 48 Bulan (Bunga: 36%)");
System.out.print("Masukkan pilihan tenor (1/2/3/4): ");
int pilihanTenor = scanner.nextInt();
switch (pilihanTenor) {
    case 1:
        jumlahBulan = 12;
        bunga = 0.10; // 10% bunga
        break;
    case 2:
        jumlahBulan = 24;
        bunga = 0.12; // 12% bunga
        break;
    case 3:
        jumlahBulan = 36;
        bunga = 0.24; // 24% bunga
        break;
    case 4:
        jumlahBulan = 48;
        bunga = 0.36; // 36% bunga
        break;
    default:
        System.out.println("Pilihan tenor tidak valid.");
        return;
}

        int angsuranPerBulan = 0;
        while (angsuranPerBulan <= 0 || angsuranPerBulan > gajiPokok) {
            System.out.println("\nMasukkan angsuran per bulan (maksimum " + formatCurrency(gajiPokok) + "): ");
            angsuranPerBulan = scanner.nextInt();
            if (angsuranPerBulan > gajiPokok) {
                System.out.println("Angsuran melebihi gaji bulanan. Mohon pilih angsuran yang lebih kecil.");
            }
        }

        System.out.println("\nSimulasi Kredit Motor:");
        System.out.println("Nama Kreditur: " + namaKreditur);
        System.out.println("Merk Motor: " + merkMotor);
        System.out.println("Harga Motor: " + formatCurrency(hargaMotor));
        System.out.println("DP Motor: " + formatCurrency(dp));
        System.out.println("Tenor: " + jumlahBulan + " bulan");
        System.out.println("Bunga: " + (bunga * 100) + "%");
        System.out.println("Nominal Angsuran per Bulan: " + formatCurrency(angsuranPerBulan));
        System.out.println("Total Angsuran selama " + jumlahBulan + " bulan: " + formatCurrency(angsuranPerBulan * jumlahBulan));
        double totalBunga = hargaMotor * bunga;
        double totalPembayaran = hargaMotor + totalBunga + (angsuranPerBulan * jumlahBulan);
        System.out.println("Total Pembayaran (Harga Motor + Total Bunga): " + formatCurrency(totalPembayaran));
      
    }

    // Metode untuk mengubah nilai double menjadi format mata uang (Rp)
    public static String formatCurrency(double value) {
        Locale localeID = new Locale("in", "ID");
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(localeID);
        return currencyFormatter.format(value);
    }
}
