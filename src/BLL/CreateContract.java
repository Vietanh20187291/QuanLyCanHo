/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import Entities.CuDan;
import Entities.HopDong;
import Entities.CanHo;
import Entities.NhanVien;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.apache.poi.xwpf.usermodel.*;

/**
 *
 * @author vanh
 */
public class CreateContract {


    public CreateContract() {
    }

    public void CreateContract(CuDan cd, HopDong hd, CanHo ch, NhanVien nv, ArrayList<String> dateDTT, ArrayList<Long> moneyDTT) throws Exception {
        //tao file word

        XWPFDocument document = new XWPFDocument();

        //tao doan van ban
        //slogan
        XWPFParagraph slogan = document.createParagraph();
        XWPFRun run = slogan.createRun();

        slogan.setAlignment(ParagraphAlignment.CENTER);
        String title = "CỘNG HÒA XÃ HỘI CHỦ NGHĨA VIỆT NAM";

        run.setFontSize(17);
        //run.setFontFamily("Times New Roman");
        run.setBold(true);
        run.setText(title);

        run.addBreak();
        String title1 = "Độc lập - Tự Do - Hạnh phúc";

        run.setText(title1);

        run.addBreak();
        String title4 = "------------";

        run.setText(title4);

        run.addBreak();
        String title2 = "HỢP ĐỒNG MUA BÁN CĂN HỘ";

        run.setText(title2);

        run.addBreak();

        XWPFRun run2 = slogan.createRun();
        String title3 = "Mã Hợp Đồng : " + hd.getMaHopDong() + "/2022";

        run2.setFontSize(14);
        run2.setText(title3);
        //Paragraph 1
        XWPFParagraph para1 = document.createParagraph();

        para1.setAlignment(ParagraphAlignment.LEFT);
        XWPFRun runPara1 = para1.createRun();

        runPara1.setFontSize(14);
        String text1 = "Căn cứ";

        runPara1.setText(text1);

        runPara1.addBreak();

        runPara1.setBold(true);;
        runPara1.setUnderline(UnderlinePatterns.THICK);

        XWPFRun runPara2 = para1.createRun();

        runPara2.setFontSize(14);
        String text2 = "-  Các quy định pháp luật hiện hành.";
        String text3 = "-  Các quyết định phê duyệt dự án.";

        runPara2.setText(text2);

        runPara2.addBreak();

        runPara2.setText(text3);

        runPara2.addBreak();

        runPara2.addBreak();
        String text4 = "Hôm nay, ngày.....tháng.....năm....., tại............., hai bên chúng tôi gồm:";

        runPara2.setText(text4);
        //Para3 Bên bán
        XWPFParagraph BenBan = document.createParagraph();
        XWPFRun runBenBanHeading = BenBan.createRun();

        runBenBanHeading.setFontSize(17);
        runBenBanHeading.setBold(true);
        String text5 = "1. BÊN BÁN CĂN HỘ ( Gọi tắt là 'Bên A'):";
        String text6 = "     Tập Đoàn Việt Anh";

        runBenBanHeading.setText(text5);

        runBenBanHeading.addBreak();

        XWPFRun runBenBan1 = BenBan.createRun();

        runBenBan1.setFontSize(14);
        runBenBan1.setText(text6);
        runBenBan1.addBreak();

        String truSo = "     Trụ sở chính: Tầng 3, Tòa nhà C’land, Khu đô thị Royal City, 72A Nguyễn Trãi , Thanh Xuân, Hà Nội";
        String sdt = "     Điện thoại: 0981 682 633";
        String fax = "Fax: 0981 696 969";
        String taikhoan = "     Tài khoản số: 0308213567213";
        String masothue = "     Mã số thuế: MSTBCL0701";
        String nguoidaidien = "     Đại diện bên A: "+nv.getHoTen();
        String chucvu = "     Mã NV: " + hd.getMaNhanVien();
        String text7 = "(Theo Giấy ủy quyền ngày.....tháng.....năm..... của...............................)";

        runBenBan1.setText(truSo);

        runBenBan1.addBreak();

        runBenBan1.setText(sdt);

        runBenBan1.addTab();

        runBenBan1.addTab();

        runBenBan1.addTab();

        runBenBan1.setText(fax);

        runBenBan1.addBreak();

        runBenBan1.setText(taikhoan);

        runBenBan1.addBreak();

        runBenBan1.setText(masothue);

        runBenBan1.addBreak();

        runBenBan1.setText(nguoidaidien);

        runBenBan1.addTab();

        runBenBan1.addTab();

        runBenBan1.setText(chucvu);

        runBenBan1.addBreak();

        runBenBan1.setText(text7);
        //Para4 Bên mua
        XWPFParagraph BenMua = document.createParagraph();
        XWPFRun runBenMuaHeading = BenMua.createRun();

        runBenMuaHeading.setFontSize(17);
        runBenMuaHeading.setBold(true);
        String text8 = "2. BÊN MUA CĂN HỘ ( Gọi tắt là 'Bên B'):";

        runBenMuaHeading.setText(text8);
        runBenMuaHeading.addBreak();

        XWPFRun runBenMua1 = BenMua.createRun();
        runBenMua1.setFontSize(14);
        String text9 = "     Ông/Bà: " + cd.getTenCuDan();
        String ngaysinh = "     Ngày sinh: " + cd.getNgaySinh();
        String socmt = "     Số CMND: " + cd.getSoCMT();
        String diachi1 = "     Địa chỉ: " + hd.getDiaChiKhachHang();
        String sdt1 = "     Số điện thoại: " + cd.getSoDT();

        runBenMua1.setText(text9);

        runBenMua1.addBreak();

        runBenMua1.setText(ngaysinh);

        runBenMua1.addBreak();

        runBenMua1.setText(socmt);

        runBenMua1.addBreak();

        runBenMua1.setText(diachi1);

        runBenMua1.addBreak();

        runBenMua1.setText(sdt1);

        // Para 5 Mua Bán
        XWPFParagraph MuaBan = document.createParagraph();
        XWPFRun runMuaBanHeading = MuaBan.createRun();
        XWPFRun runMuaBan = MuaBan.createRun();

        runMuaBanHeading.setFontSize(17);
        runMuaBanHeading.setBold(true);
        runMuaBan.setFontSize(14);
        //  runMuaBan.setBold(true);
        String mb1 = "3. THÔNG TIN MUA BÁN :";
        String mb2 = "     Bên A có đầy đủ quyền sở hữu hợp pháp đối với căn hộ :";
        String mb3 = "     Mã Căn Hộ: " + ch.getMaCanHo();
        String mb4 = "     Diện Tích: " + ch.getDienTich() + " m²";
        String mb5 = "     Số Phòng: " + ch.getSoPhong();
        String mb6 = "     Khu Căn Hộ: " + ch.getTenKhu();

        String mb7 = "     Bằng hợp đồng này Bên A đồng ý bán, Bên B đồng ý mua toàn bộ căn hộ nêu trên với những điều khoản thỏa thuận dưới đây:";
        String mb8 = "     1. Giá mua bán hai bên thoả thuận là " + convertMoney(ch.getGia()) + " đồng (trả bằng tiền Nhà nước Việt Nam hiện hành) đã bao gồm các loại thuế phí. Nếu có thuế phí phát sinh sẽ do bên A chịu trách nghiệm chi trả";
        String mb9 = "     2. Bên A có nghĩa vụ giao căn hộ nêu trên cùng toàn bộ bản chính giấy tờ hợp pháp về quyền sở hữu căn hộ cho Bên B.";
        String mb10 = "     3. Việc giao nhận căn hộ và giấy tờ kèm theo do hai bên tự thực hiện và chịu trách nhiệm trước pháp luật.";
        String mb11 = "     4. Bên A đã nhận đầy đủ số tiền đặt cọc trước của bên B có giá trị là " + convertMoney(hd.getCoc()) + " đồng.";
        String mb12 = "     5. Bên B có nghĩa vụ thanh toán số tiền còn lại là " + convertMoney(ch.getGia() - hd.getCoc()) + " đồng cho bên A đúng thời hạn theo " + dateDTT.size() + " đợt và đăng ký quyền sở hữu căn hộ tại cơ quan có thẩm quyền theo quy định của pháp luật.";
        String mb13 = "     6. Chi tiết các đợt thanh toán: ";
        ArrayList<String> DTT = new ArrayList<>();
        for (int i = 0; i < dateDTT.size(); i++) {
            DTT.add("   Số Tiền Đợt " + (i + 1) + ": " + convertMoney(moneyDTT.get(i)) + "                                           Thời Hạn: " + dateDTT.get(i));
        }
        String mb14 = "";
        String mb15 = "   7. Trong mỗi đợt thanh toán, Bên B có thể chia ra thành các giao dịch nhỏ thanh toán một phần số tiền.";
        String mb16 = "   8. Đến hết đợt thanh toán nếu Bên B vẫn chưa thanh toán hết số tiền, số tiền còn lại sẽ được tính lãi 0.5% cho mỗi tháng chậm trễ";
        String mb17 = "     Bản Hợp đồng này có hiệu lực ngay sau khi hai bên ký kết và được lập thành 05 (năm) bản, có giá trị như nhau, mỗi bên giữ 02 (hai) bản và lưu một (01) bản tại Phòng Công chứng.";
        String mb18 = "     Mọi sửa đổi, bổ sung hoặc huỷ bỏ Hợp đồng này chỉ có giá trị khi được hai bên đồng thuận và lập thành văn bản có đầy đủ chữ ký của các bên và chỉ được thực hiện khi Bên mua chưa đăng ký sang tên quyền sở hữu theo Hợp đồng này.";

        runMuaBanHeading.setText(mb1);
        runMuaBanHeading.addBreak();

        run(runMuaBan, mb2);
        run(runMuaBan, mb3);
        run(runMuaBan, mb4);
        run(runMuaBan, mb5);
        run(runMuaBan, mb6);
        run(runMuaBan, mb7);
        run(runMuaBan, mb8);
        run(runMuaBan, mb9);
        run(runMuaBan, mb10);
        run(runMuaBan, mb11);
        run(runMuaBan, mb12);
        run(runMuaBan, mb13);
        for (int i = 0; i < DTT.size(); i++) {
            run(runMuaBan, DTT.get(i));
        }
        run(runMuaBan, mb14);
        run(runMuaBan, mb15);
        run(runMuaBan, mb16);
        run(runMuaBan, mb17);
        run(runMuaBan, mb18);
        //Ký tên
        XWPFTable KyTen = document.createTable();

        KyTen.setWidth(
                "9500");

        KyTen.setTableAlignment(TableRowAlign.CENTER);

        KyTen.removeBorders();

        XWPFParagraph para3 = document.createParagraph();

        para3.setAlignment(ParagraphAlignment.CENTER);

        XWPFTableRow rowOne = KyTen.getRow(0);

        rowOne.getCell(0).setParagraph(para3);
        rowOne.getCell(0).setText("BÊN A");
        rowOne.addNewTableCell()
                .setParagraph(para3);
        rowOne.getCell(1).setText("BÊN B");

        XWPFTableRow rowTwo = KyTen.createRow();

        rowTwo.getCell(0).setParagraph(para3);
        rowTwo.getCell(0).setText("(Ký ghi rõ họ tên, nếu là tổ chức mua nhà thì đóng dấu của tổ chức)");

        rowTwo.getCell(1).setParagraph(para3);
        rowTwo.getCell(1).setText("(Ký ghi rõ họ tên, chức vụ và đóng dấu của doanh nghiệp)");

        //ghi file
        try {
            String text = "HopDongMuaBanCanHo_" + hd.getMaHopDong() + ".docx";
            FileOutputStream out = new FileOutputStream(new File(text));
            document.write(out);
            out.close();
            document.close();
            JOptionPane.showMessageDialog(null, "Tạo hợp đồng thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);

        } catch (IOException e) {
            System.out.println(e);
            System.out.println(e.getMessage());
        }

    }
        private static String convertMoney(Long number) {
		String numberInText = String.valueOf(number);
		
		int numberLength = numberInText.length();
		
		if(numberLength < 4) return numberInText;
		
		StringBuilder sb = new StringBuilder("");
		
		for(int i = 0, j = numberLength % 3 == 0 ? 3 : numberLength % 3; i < numberLength; ++i) {
			
			if(j < numberLength && i == j) {
				sb.append(".");
				j += 3;
			}
			
			sb.append(numberInText.charAt(i));
		}
		
		return sb.toString();
	}

    private void run(XWPFRun methodRun, String text) {
        methodRun.setText(text);
        methodRun.addBreak();
    }
}
