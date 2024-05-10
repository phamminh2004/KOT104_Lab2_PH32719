package fpoly.minhpt.lab2_ph32719

data class SinhVien(
    var ten: String,
    var mssv: String,
    var diemTB: Float,
    var daTotNghiep: Boolean?,
    var tuoi: Int?
)

class QuanLySinhVien {
    private val danhSachSinhVien = mutableListOf<SinhVien>()

    fun themSinhVien() {
        println("Mời nhập tên: ")
        var ten = readln()
        println("Mời nhập mssv: ")
        var mssv = readln()
        println("Mời nhập điểm: ")
        var diemTB = readln().toFloat()
        println("Đã tốt nghiệp chưa: (true/false)")
        var daTotNghiep = readLine()?.toBooleanStrictOrNull()
        println("Mời nhập tuổi: ")
        var tuoi = readLine()?.toIntOrNull()
        var sinhVien = SinhVien(ten, mssv, diemTB, daTotNghiep, tuoi)
        danhSachSinhVien.add(sinhVien)
        println("Thêm sinh viên thành công.")
    }

    fun xoaSinhVien() {
        println("Mời nhập mssv: ")
        var mssv = readln()
        val sinhVien = danhSachSinhVien.find { it.mssv == mssv }
        sinhVien?.let { danhSachSinhVien.remove(it) }
        println("Xóa sinh viên có mssv là $mssv thành công.")
    }

    fun suaSinhVien() {
        println("Mời nhập mssv: ")
        var mssv = readln()
        val index = danhSachSinhVien.indexOfFirst { it.mssv == mssv }
        if (index != -1) {
            println("Mời nhập tên: ")
            var ten = readln()
            println("Mời nhập mssv: ")
            var mssv = readln()
            println("Mời nhập điểm: ")
            var diemTB = readln().toFloat()
            println("Đã tốt nghiệp chưa: (true/flase)")
            var daTotNghiep = readLine()?.toBooleanStrictOrNull()
            println("Mời nhập tuổi: ")
            var tuoi = readLine()?.toIntOrNull()
            var sinhVienMoi = SinhVien(ten, mssv, diemTB, daTotNghiep, tuoi)
            danhSachSinhVien[index] = sinhVienMoi
        } else {
            println("Không tìm thấy sinh viên có mã số $mssv")
        }
    }

    fun xemDanhSachSinhVien() {
        if (danhSachSinhVien.size == 0) {
            println("Danh sách sinh viên trống.")
        } else {
            danhSachSinhVien.forEach {
                println("Tên: ${it.ten}, MSSV: ${it.mssv}, Điểm TB: ${it.diemTB}, Đã tốt nghiệp: ${it.daTotNghiep}, Tuổi: ${it.tuoi}")
            }
        }
    }
}

fun main() {
    val quanLySV = QuanLySinhVien()
    var s: String?
    println("1. Xem danh sách SV")
    println("2. Thêm SV")
    println("3. Sửa SV")
    println("4. Xóa SV")
    do {
        println("Mời chọn: ")
        s = readLine()
        when (s) {
            "1" -> {
                quanLySV.xemDanhSachSinhVien()
            }

            "2" -> {
                quanLySV.themSinhVien()
            }

            "3" -> {
                quanLySV.suaSinhVien()
            }

            "4" -> {
                quanLySV.xoaSinhVien()
            }

            else -> println("Không hợp lệ. Mời chọn lại. ")

        }

        print("Tiếp không?(c/k):")
        s = readLine()
        if (s == "k")
            break;
    } while (true)
}
