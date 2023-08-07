 import java.util.Scanner;

public class kredit2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan nama kreditur: ");
        String namaKreditur = scanner.nextLine();

        System.out.print("Masukkan gaji pokok: ");
        double gajiPokok = scanner.nextDouble();

        System.out.print("Masukkan kategori merk motor (1=Yamaha, 2=Honda, 3=Suzuki): ");
        int kategoriMerk = scanner.nextInt();

        double hargaMotor = 0;
        String merkMotor = "";

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

        double dp = 0;
        while (dp <= 0 || dp > hargaMotor / 2) {
            System.out.print("Masukkan jumlah DP (maksimum " + (hargaMotor / 2) + "): ");
            dp = scanner.nextDouble();
            if (dp > hargaMotor / 2) {
                System.out.println("DP melebihi batas maksimum.");
            }
        }

        int jumlahBulan;
        double bunga;

        System.out.println("Pilihan Tenor:");
        System.out.println("1. 12 Bulan (Bunga: 12%)");
        System.out.println("2. 24 Bulan (Bunga: 12.5%)");
        System.out.println("3. 36 Bulan (Bunga: 15%)");
        System.out.print("Masukkan pilihan tenor (1/2/3): ");
        int pilihanTenor = scanner.nextInt();

        switch (pilihanTenor) {
            case 1:
                jumlahBulan = 12;
                bunga = 0.12;
                break;
            case 2:
                jumlahBulan = 24;
                bunga = 0.125;
                break;
            case 3:
                jumlahBulan = 36;
                bunga = 0.15;
                break;
            default:
                System.out.println("Pilihan tenor tidak valid.");
                return;
        }

        double sisaHutang = hargaMotor - dp;
        double angsuranPerBulan = (sisaHutang * (1 + bunga)) / jumlahBulan;

        System.out.println("\nSimulasi Kredit Motor:");
        System.out.println("Nama Kreditur: " + namaKreditur);
        System.out.println("Merk Motor: " + merkMotor);
        System.out.println("DP Motor: " + dp);
        System.out.println("Nominal Angsuran per Bulan: " + angsuranPerBulan);
        System.out.println("Total Angsuran selama " + jumlahBulan + " bulan: " + (angsuranPerBulan * jumlahBulan));
    }

}

    

 
    
    

