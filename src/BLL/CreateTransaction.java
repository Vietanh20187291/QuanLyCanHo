/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import Entities.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import org.apache.poi.xwpf.usermodel.*;

/**
 *
 * @author vanh
 */
public class CreateTransaction {



    public CreateTransaction() {
    }

    public void CreateTransaction(HopDong hd, DotThanhToan dtt, GiaoDich gd, NhanVien nv, CuDan cd) throws Exception {
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
        String title2 = "BIÊN BẢN GIAO NHẬN TIỀN GIAO DỊCH";

        run.setText(title2);

        run.addBreak();

        XWPFRun run2 = slogan.createRun();
        String title3 = "Mã Giao Dịch : " + gd.getMaGiaoDich() + "/" + dtt.getMaDot();

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
        String text2 = "-  Hợp đồng mua bán căn hộ " + hd.getMaCanHo() + " giữa Tập Đoàn Việt Anh và khách hàng " + cd.getTenCuDan()+", mã hợp đồng : "+hd.getMaHopDong();
        String text3 = "-  Quy định về giao dịch dân sự pháp luật Việt Nam hiện hành.";

        runPara2.setText(text2);

        runPara2.addBreak();

        runPara2.setText(text3);

        runPara2.addBreak();

        runPara2.addBreak();
        String text4 = "Hôm nay, ngày.....tháng.....năm....., tại............., hai bên chúng tôi gồm:";

        runPara2.setText(text4);
        //Para 3 Bên Giao
        XWPFParagraph BenGiao = document.createParagraph();
        XWPFRun runBenGiaoHeading = BenGiao.createRun();
        XWPFRun runBenGiao = BenGiao.createRun();

        runBenGiaoHeading.setFontSize(17);
        runBenGiaoHeading.setBold(true);
        runBenGiao.setFontSize(14);
        
        String bg1 = "1. BÊN GIAO TIỀN ( Gọi tắt là 'Bên A'):";
        String bg2 = "     Ông/Bà: " + cd.getTenCuDan();
        String bg3 = "     Ngày sinh: " + cd.getNgaySinh();
        String bg4 = "     Số CMND: " + cd.getSoCMT();
        String bg5 = "     Địa chỉ: " + hd.getDiaChiKhachHang();
        String bg6 = "     Số điện thoại: " + cd.getSoDT();

        run(runBenGiaoHeading,bg1);
        run(runBenGiao,bg2);
        run(runBenGiao,bg3);
        run(runBenGiao,bg4);
        run(runBenGiao,bg5);
        run(runBenGiao,bg6);
        
        //Para4 Bên bán
        XWPFParagraph BenBan = document.createParagraph();
        XWPFRun runBenBanHeading = BenBan.createRun();
        XWPFRun runBenBan = BenBan.createRun();

        runBenBanHeading.setFontSize(17);
        runBenBanHeading.setBold(true);
        runBenBan.setFontSize(14);
        String bb1 = "2. BÊN NHẬN TIỀN ( Gọi tắt là 'Bên B'):";
        String bb2 = "     Tập Đoàn Việt Anh";
        String bb3 = "     Trụ sở chính: Tầng 3, Tòa nhà C’land, Khu đô thị Royal City, 72A Nguyễn Trãi , Thanh Xuân, Hà Nội";
        String bb4 = "     Điện thoại: 0981 682 633";
        String bb5 = "     Fax: 0981 696 969";
        String bb6 = "     Tài khoản số: 0308213567213";
        String bb7 = "     Mã số thuế: MSTBCL0701";
        String bb8 = "     Đại diện bên A: " + nv.getHoTen();
        String bb9 = "     Mã NV: " + hd.getMaNhanVien();
        String bb10 = "(Theo Giấy ủy quyền ngày.....tháng.....năm..... của...............................)";

        run(runBenBanHeading, bb1);
        run(runBenBan, bb2);
        run(runBenBan, bb3);
        run(runBenBan, bb4);
        run(runBenBan, bb5);
        run(runBenBan, bb6);
        run(runBenBan, bb7);
        run(runBenBan, bb8);
        run(runBenBan, bb9);
        run(runBenBan, bb10);


        // Para 5 Mua Bán
        XWPFParagraph MuaBan = document.createParagraph();
        XWPFRun runMuaBanHeading = MuaBan.createRun();
        XWPFRun runMuaBan = MuaBan.createRun();

        runMuaBanHeading.setFontSize(17);
        runMuaBanHeading.setBold(true);
        runMuaBan.setFontSize(14);
        //  runMuaBan.setBold(true);
        String mb1 = "3. THÔNG TIN GIAO DỊCH :";
        String mb2  = "     Mã Giao Dịch : "+gd.getMaGiaoDich();
        String mb3  = "     Ngày Giao Dịch :"+convertToDate(gd.getNgayGiaoDich());
        String mb4 = "     Căn cứ theo hợp đồng được ký kết giữa hai bên:";
        String mb5 = "     Hôm nay, ngày "+convertToDate(gd.getNgayGiaoDich())+", Bên B đã nhận số tiền là " + convertMoney(gd.getSoTien()) +" Đồng từ bên A để thanh toán cho đợt thanh toán số "+dtt.getDotSo()+" của hợp đồng "+ hd.getMaHopDong();
        String mb6 = "     Mã Đợt Thanh Toán : " + dtt.getMaDot();
        String mb7 = "     Thời Hạn Đợt Thanh Toán: " + convertToDate(dtt.getThoiHan());
        String mb8 = "     Số Tiền Bên A còn phải trả trong Đợt Thanh Toán: " + convertMoney(dtt.getSoTienThieu()-gd.getSoTien())+" Đồng";
        String mb9 = "     Nếu Bên A thanh toán muộn hơn kỳ hạn, số tiền còn lại sẽ được tính lãi 0.5% cho mỗi tháng chậm trễ";


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
            String text = "BienBanGiaoDich_" + gd.getMaGiaoDich() + ".docx";
            FileOutputStream out = new FileOutputStream(new File(text));
            document.write(out);
            out.close();
            document.close();
            JOptionPane.showMessageDialog(null, "Tạo hợp đồng thành công.");

        } catch (IOException e) {
            System.out.println(e);
            System.out.println(e.getMessage());
        }

    }
    private static String convertToDate(Long value) {
        Date date = new Date(value);
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String dateText = df.format(date);
        return dateText;
    }
    private void run(XWPFRun methodRun, String text) {
        methodRun.setText(text);
        methodRun.addBreak();
    }
        private static String convertMoney(Long number) {
        String numberInText = String.valueOf(number);

        int numberLength = numberInText.length();

        if (numberLength < 4) {
            return numberInText;
        }

        StringBuilder sb = new StringBuilder("");

        for (int i = 0, j = numberLength % 3 == 0 ? 3 : numberLength % 3; i < numberLength; ++i) {

            if (j < numberLength && i == j) {
                sb.append(".");
                j += 3;
            }

            sb.append(numberInText.charAt(i));
        }

        return sb.toString();
    }
}
