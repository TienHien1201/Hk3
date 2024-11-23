package Conntroller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.JFrame;

import Myconnector.JDBCUnitl;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import View.TableView;
import dao.ChuyenNghanhDataAccessObject;
import dao.DiaChiDataAccessObject;
import dao.DiemThiDataAccessObject;
import dao.DienThoaiDataAccessObject;
import dao.GiangVienDataAccessObject;
import dao.KhoaDataAccessObject;
import dao.MonThiDataAccessObject;
import dao.SinhVienDataAccessObject;
import dao.ThiDataAccessObject;
import dao.lopDataAccessObject;
import model.ChuyenNganh;
import model.DiaChi;
import model.DiemThi;
import model.DienThoai;
import model.GiangVien;
import model.Khoa;
import model.Lop;
import model.MonThi;
import model.SinhVien;
import model.Thi;

public class EventQLSV implements ActionListener {
    TableView view;
    
    public EventQLSV(TableView view,JTextField textFieldInputSQL, JTable table) {
        super();
        this.view = view;
    }
    
    private void showInsertDialog() {
        String[] model = { "ChuyenNganh", "DiaChi", "DiemThi", "DienThoai", "GiangVien", "Khoa", "Lop", "MonThi", "SinhVien", "Thi" };
        JComboBox<String> modelComboBox = new JComboBox<>(model);
        
        // Hiển thị thông báo "Chọn Table muốn insert"
        int InsertResurt = JOptionPane.showConfirmDialog(view, modelComboBox, "Chọn Table muốn insert", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (InsertResurt == JOptionPane.OK_OPTION) {
            String selectedModel = (String) modelComboBox.getSelectedItem();
            AcctionInsertDialog(selectedModel);
        }
    }
    private void showUpdateDialog() {
        String[] model = { "ChuyenNganh", "DiaChi", "DiemThi", "DienThoai", "GiangVien", "Khoa", "Lop", "MonThi", "SinhVien", "Thi" };
        JComboBox<String> modelComboBox = new JComboBox<>(model);

        // Hiển thị thông báo "Chọn Table muốn update"
        int updateResurt = JOptionPane.showOptionDialog(view, modelComboBox, "Chọn Table muốn update", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);

        if (updateResurt == JOptionPane.OK_OPTION) {
            String selectedModel = (String) modelComboBox.getSelectedItem();
            AcctionUpdateDialog(selectedModel);
        }
    }
    private void showDeleteteDialog() {
        String[] model = { "ChuyenNganh", "DiaChi", "DiemThi", "DienThoai", "GiangVien", "Khoa", "Lop", "MonThi", "SinhVien", "Thi" };
        JComboBox<String> modelComboBox = new JComboBox<>(model);

        // Hiển thị thông báo "Chọn Table muốn update"
        int deleteResurt = JOptionPane.showOptionDialog(view, modelComboBox, "Chọn Table muốn Delete", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);

        if (deleteResurt == JOptionPane.OK_OPTION) {
            String selectedModel = (String) modelComboBox.getSelectedItem();
            AcctionDelete(selectedModel);
        }
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();

        if ("Insert".equals(actionCommand)) {
            showInsertDialog();
        } else if("Update".equals(actionCommand)) {
        	showUpdateDialog();
        }
        else if("Delete".equals(actionCommand)) {
        	showDeleteteDialog();
        	}
    }

   
    private void AcctionInsertDialog(String selectedModel) {
        if ("ChuyenNganh".equals(selectedModel)) {
            ChuyenNganh chuyenNganh = InputChuyenNganh.showInputDialog();
            if (chuyenNganh != null) {
                // TODO: Thực hiện thao tác với đối tượng chuyenNganh đểlưu vào cơ sở dữ liệu.
                // Ví dụ: chuyenNganhDAO.insert(chuyenNganh); .....
                int InsertResurt = ChuyenNghanhDataAccessObject.getInstance().Insert(chuyenNganh);
                
                if (InsertResurt > 0 ) {
                    JOptionPane.showMessageDialog(view, "Đã thêm Chuyên Ngành: " 
                    + chuyenNganh.getMACN()
                    +"," + chuyenNganh.getTENCN()
                    +"," + chuyenNganh.getMAGVQL()
                    +"," + chuyenNganh.getMAKHOA());
                } 
                else {
                    JOptionPane.showMessageDialog(view, "Thao tác với Chuyên Nghành thất bại ");
                }}
             else {
                JOptionPane.showMessageDialog(view, "Thao tác với Chuyên Nghành thất bại");
            }
        }
        
        else if ("DiaChi".equals(selectedModel)) {
            DiaChi diachi = InputDiaChi.showInputDialog();
            if (diachi != null) {
                // TODO: Thực hiện thao tác với đối tượng diachi để lưu vào cơ sở dữ liệu.
                int InsertResurt = DiaChiDataAccessObject.getInstance().Insert(diachi);
               
                if (InsertResurt > 0) {
                    JOptionPane.showMessageDialog(view, "Đã thêm Địa Chỉ: " 
                +diachi.getMASV()
                + "," + diachi.getSONhA()
                + "," + diachi.getDUONG()
                + "," + diachi.getQUAN()
                + "," + diachi.getTHANHPHO());
                }
                else {
                    JOptionPane.showMessageDialog(view, "Thao tác với Địa Chỉ thất bại");
                }
            } else {
                JOptionPane.showMessageDialog(view, "Thao tác với Địa Chỉ thất bại");
            }
        }
        else if ("DiemThi".equals(selectedModel)) {
            DiemThi diemthi = InputDiemThi.showInputDialog();
            if (diemthi != null ) {
                // TODO: Thực hiện thao tác với đối tượng DiemThi để lưu vào cơ sở dữ liệu.
               
                int InsertResurt = DiemThiDataAccessObject.getInstance().Insert(diemthi);
                if (InsertResurt > 0) {
                    JOptionPane.showMessageDialog(view, "Đã thêm Điểm Thi: " 
                +diemthi.getMASV()
                + "," + diemthi.getMAMT()
                + "," + diemthi.getDIEM()
                + "," + diemthi.getGHICHU());
                }  else {
                    JOptionPane.showMessageDialog(view, "Thao tác với Điểm Thi thất bại");
                }
            } else {
            	JOptionPane.showMessageDialog(view, "Thao tác với Điểm thi thất bại");
            }
        }
        else if ("DienThoai".equals(selectedModel)) {
            DienThoai dienthoai = InputDienThoai.showInputDialog();
            if (dienthoai != null) {
                // TODO: Thực hiện thao tác với đối tượng DienThoai để lưu vào cơ sở dữ liệu.
                int InsertResurt = DienThoaiDataAccessObject.getInstance().Insert(dienthoai);
                
                if (InsertResurt > 0) {
                    JOptionPane.showMessageDialog(view, "Đã thêm Điện Thoại: " 
                +dienthoai.getMASV()
                + "," + dienthoai.getSODT());
                } 
               else {
                    JOptionPane.showMessageDialog(view, "Thao tác với Điện Thọai thất bại");
                }
            } else {
                JOptionPane.showMessageDialog(view, "Thao tác với Điện thọai thất bại");
            }
        }
        else if ("GiangVien".equals(selectedModel)) {
            GiangVien giangvien = InputGiangVien.showInputDialog();
            if (giangvien != null) {
                // TODO: Thực hiện thao tác với đối tượng GiangVien để lưu vào cơ sở dữ liệu.
                int InsertResurt = GiangVienDataAccessObject.getInstance().Insert(giangvien);
               
                if (InsertResurt > 0) {
                    JOptionPane.showMessageDialog(view, "Đã thêm Giảng Viên: " 
                +giangvien.getMAGV()
                + "," + giangvien.getTENGV()
                + "," + giangvien.getSODT()
                + "," + giangvien.getMAKHOA());
                } 
                else {
                    JOptionPane.showMessageDialog(view, "Thao tác với Giảng Viên thất bại");
                }
            } else {
                JOptionPane.showMessageDialog(view, "Thao tác với Giảng Viên thất bại");
            }
        }
        else if ("Khoa".equals(selectedModel)) {
            Khoa khoa = InputKhoa.showInputDialog();
            if (khoa != null) {
                // TODO: Thực hiện thao tác với đối tượng Khoa để lưu vào cơ sở dữ liệu.
                int InsertResurt = KhoaDataAccessObject.getInstance().Insert(khoa);
               
                if (InsertResurt > 0) {
                    JOptionPane.showMessageDialog(view, "Đã thêm Khoa: " 
                +khoa.getMAKHOA()
                + "," + khoa.getTENKHOA()
                + "," + khoa.getNAMTL()
                + "," + khoa.getPHONGLV()
                + "," + khoa.getTEL()
                + "," + khoa.getMATRGKHOA());
                } else {
                    JOptionPane.showMessageDialog(view, "Thao tác với Khoa thất bại");
                }
            } else {
                JOptionPane.showMessageDialog(view, "Thao tác với Khoa thất bại");
            }
        }
        else if ("Lop".equals(selectedModel)) {
            Lop lop = InputLop.showInputDialog();
            if (lop != null) {
                // TODO: Thực hiện thao tác với đối tượng lop để lưu vào cơ sở dữ liệu.
                int InsertResurt = lopDataAccessObject.getInstance().Insert(lop);
               
                if (InsertResurt > 0) {
                    JOptionPane.showMessageDialog(view, "Đã thêm Lớp: " 
                +lop.getMAL()
                + "," + lop.getSISO()
                + "," + lop.getMACN());
                } else {
                    JOptionPane.showMessageDialog(view, "Thao tác với Lớp thất bại");
                }
            } else {
                JOptionPane.showMessageDialog(view, "Thao tác với Lớp thất bại");
            }
        }
        else if ("MonThi".equals(selectedModel)) {
            MonThi  monthi = InputMonThi.showInputDialog();
            if (monthi != null) {
                // TODO: Thực hiện thao tác với đối tượng monthi để lưu vào cơ sở dữ liệu.
                int InsertResurt = MonThiDataAccessObject.getInstance().Insert(monthi);
               
                if (InsertResurt > 0) {
                    JOptionPane.showMessageDialog(view, "Đã thêm Môn Thi: " 
                +monthi.getMaMT()
                + "," + monthi.getTENMT());
                } else {
                    JOptionPane.showMessageDialog(view, "Thao tác với Môn Thi thất bại");
                }
            } else {
                JOptionPane.showMessageDialog(view, "Thao tác với Môn Thi thất bại");
            }
        }
        else if ("SinhVien".equals(selectedModel)) {
            SinhVien  sinhvien = InputSinhVien.showInputDialog();
            if (sinhvien != null) {
                // TODO: Thực hiện thao tác với đối tượng sinhvien để lưu vào cơ sở dữ liệu.
                int InsertResurt = SinhVienDataAccessObject.getInstance().Insert(sinhvien);
               
                if (InsertResurt > 0) {
                    JOptionPane.showMessageDialog(view, "Đã thêm Sinh Viên: " 
                +sinhvien.getMASV()
                + "," + sinhvien.getHOTEN()
                + "," + sinhvien.getNGSINH()
                + "," + sinhvien.getPHAI()
                + "," + sinhvien.getMAL());
                } else {
                    JOptionPane.showMessageDialog(view, "Thao tác với Sinh Viên thất bại");
                }
            } else {
                JOptionPane.showMessageDialog(view, "Thao tác với Sinh Viên thất bại");
            }
        }
        else if ("Thi".equals(selectedModel)) {
            Thi thi = InputThi.showInputDialog();
            if (thi != null) {
                // TODO: Thực hiện thao tác với đối tượng thi để lưu vào cơ sở dữ liệu.
                int InsertResurt = ThiDataAccessObject.getInstance().Insert(thi);
                
                if (InsertResurt > 0) {
                    JOptionPane.showMessageDialog(view, "Đã thêm Thi: " 
                +thi.getMaMT()
                + "," + thi.getMaCN());
                } else {
                    JOptionPane.showMessageDialog(view, "Thao tác với Thi thất bại");
                }
            } else {
                JOptionPane.showMessageDialog(view, "Thao tác với Thi thất bại");
            }
        }   
    }
    
    private void AcctionUpdateDialog(String selectedModel) {
        if ("ChuyenNganh".equals(selectedModel)) {
            ChuyenNganh chuyenNganh = InputChuyenNganh.showInputDialog();
            if (chuyenNganh != null) {
                // TODO: Thực hiện thao tác với đối tượng chuyenNganh đểlưu vào cơ sở dữ liệu.
                // Ví dụ: chuyenNganhDAO.insert(chuyenNganh); .....
               
                int UpdateResurt = ChuyenNghanhDataAccessObject.getInstance().Uppdate(chuyenNganh);
               if(UpdateResurt > 0){
                	 JOptionPane.showMessageDialog(view, "Đã cập nhật Chuyên Ngành mới: " 
                             + chuyenNganh.getMACN()
                             +"," + chuyenNganh.getTENCN()
                             +"," + chuyenNganh.getMAGVQL()
                             +"," + chuyenNganh.getMAKHOA());
                }else {
                    JOptionPane.showMessageDialog(view, "Thao tác với Chuyên Nghành thất bại ");
                }
               }else {
                JOptionPane.showMessageDialog(view, "Thao tác với Chuyên Nghành thất bại");
            }
        }
        
        else if ("DiaChi".equals(selectedModel)) {
            DiaChi diachi = InputDiaChi.showInputDialog();
            if (diachi != null) {
                // TODO: Thực hiện thao tác với đối tượng diachi để lưu vào cơ sở dữ liệu.
                int UpdateResurt = DiaChiDataAccessObject.getInstance().Uppdate(diachi);
                if(UpdateResurt > 0){
                	  JOptionPane.showMessageDialog(view, "Đã cập nhật Địa Chỉ mới: " 
                              +diachi.getMASV()
                              + "," + diachi.getSONhA()
                              + "," + diachi.getDUONG()
                              + "," + diachi.getQUAN()
                              + "," + diachi.getTHANHPHO());
                } else {
                    JOptionPane.showMessageDialog(view, "Thao tác với Địa Chỉ thất bại");
                }
            } else {
                JOptionPane.showMessageDialog(view, "Thao tác với Địa Chỉ thất bại");
            }
        }
        else if ("DiemThi".equals(selectedModel)) {
            DiemThi diemthi = InputDiemThi.showInputDialog();
            if (diemthi != null ) {
                // TODO: Thực hiện thao tác với đối tượng DiemThi để lưu vào cơ sở dữ liệu.
               
                int UpdateResurt = DiemThiDataAccessObject.getInstance().Uppdate(diemthi);
                  if (UpdateResurt > 0) {
                	JOptionPane.showMessageDialog(view, "Đã cập nhật Điểm Thi mới: " 
                            +diemthi.getMASV()
                            + "," + diemthi.getMAMT()
                            + "," + diemthi.getDIEM()
                            + "," + diemthi.getGHICHU());
				}  else {
                    JOptionPane.showMessageDialog(view, "Thao tác với Điểm Thi thất bại");
                }
            } else {
            	JOptionPane.showMessageDialog(view, "Thao tác với Điểm thi thất bại");
            }
        }
        else if ("DienThoai".equals(selectedModel)) {
            DienThoai dienthoai = InputDienThoai.showInputDialog();
            if (dienthoai != null) {
                // TODO: Thực hiện thao tác với đối tượng DienThoai để lưu vào cơ sở dữ liệu. 
                int UpdateResurt = DienThoaiDataAccessObject.getInstance().Uppdate(dienthoai);
                if(UpdateResurt > 0) {
                	   JOptionPane.showMessageDialog(view, "Đã cập nhật Điện Thoại mới: " 
                               +dienthoai.getMASV()
                               + "," + dienthoai.getSODT());
                } else {
                    JOptionPane.showMessageDialog(view, "Thao tác với Điện Thọai thất bại");
                }
            } else {
                JOptionPane.showMessageDialog(view, "Thao tác với Điện thọai thất bại");
            }
        }
        else if ("GiangVien".equals(selectedModel)) {
            GiangVien giangvien = InputGiangVien.showInputDialog();
            if (giangvien != null) {
                // TODO: Thực hiện thao tác với đối tượng GiangVien để lưu vào cơ sở dữ liệu.
               
                int UpdateResurt = GiangVienDataAccessObject.getInstance().Uppdate(giangvien);
                if (UpdateResurt > 0) {
                	JOptionPane.showMessageDialog(view, "Đã cập nhật Giảng Viên mới: " 
                            +giangvien.getMAGV()
                            + "," + giangvien.getTENGV()
                            + "," + giangvien.getSODT()
                            + "," + giangvien.getMAKHOA());
				} else {
                    JOptionPane.showMessageDialog(view, "Thao tác với Giảng Viên thất bại");
                }
            } else {
                JOptionPane.showMessageDialog(view, "Thao tác với Giảng Viên thất bại");
            }
        }
        else if ("Khoa".equals(selectedModel)) {
            Khoa khoa = InputKhoa.showInputDialog();
            if (khoa != null) {
                // TODO: Thực hiện thao tác với đối tượng Khoa để lưu vào cơ sở dữ liệu.
                
                int UpdateResurt = KhoaDataAccessObject.getInstance().Uppdate(khoa);
                if (UpdateResurt > 0) {
                	JOptionPane.showMessageDialog(view, "Đã cập nhật Khoa mới: " 
                            +khoa.getMAKHOA()
                            + "," + khoa.getTENKHOA()
                            + "," + khoa.getNAMTL()
                            + "," + khoa.getPHONGLV()
                            + "," + khoa.getTEL()
                            + "," + khoa.getMATRGKHOA());
				}  else {
                    JOptionPane.showMessageDialog(view, "Thao tác với Khoa thất bại");
                }
            } else {
                JOptionPane.showMessageDialog(view, "Thao tác với Khoa thất bại");
            }
        }
        else if ("Lop".equals(selectedModel)) {
            Lop lop = InputLop.showInputDialog();
            if (lop != null) {
                // TODO: Thực hiện thao tác với đối tượng lop để lưu vào cơ sở dữ liệu.
             
                int UpdateResurt = lopDataAccessObject.getInstance().Uppdate(lop);
                 if (UpdateResurt > 0) {
                	 JOptionPane.showMessageDialog(view, "Đã cập nhật Lớp mới: " 
                             +lop.getMAL()
                             + "," + lop.getSISO()
                             + "," + lop.getMACN());
				} else {
                    JOptionPane.showMessageDialog(view, "Thao tác với Lớp thất bại");
                }
            } else {
                JOptionPane.showMessageDialog(view, "Thao tác với Lớp thất bại");
            }
        }
        else if ("MonThi".equals(selectedModel)) {
            MonThi  monthi = InputMonThi.showInputDialog();
            if (monthi != null) {
                // TODO: Thực hiện thao tác với đối tượng monthi để lưu vào cơ sở dữ liệu.
              
                int UpdateResurt = MonThiDataAccessObject.getInstance().Uppdate(monthi);
                if (UpdateResurt > 0) {
                	JOptionPane.showMessageDialog(view, "Đã cập nhật Môn Thi mới: " 
                            +monthi.getMaMT()
                            + "," + monthi.getTENMT());
				} else {
                    JOptionPane.showMessageDialog(view, "Thao tác với Môn Thi thất bại");
                }
            } else {
                JOptionPane.showMessageDialog(view, "Thao tác với Môn Thi thất bại");
            }
        }
        else if ("SinhVien".equals(selectedModel)) {
            SinhVien  sinhvien = InputSinhVien.showInputDialog();
            if (sinhvien != null) {
                // TODO: Thực hiện thao tác với đối tượng sinhvien để lưu vào cơ sở dữ liệu.
                
                int UpdateResurt = SinhVienDataAccessObject.getInstance().Uppdate(sinhvien);
                if (UpdateResurt > 0) {
                	 JOptionPane.showMessageDialog(view, "Đã cập nhật Sinh Viên mới: " 
                             +sinhvien.getMASV()
                             + "," + sinhvien.getHOTEN()
                             + "," + sinhvien.getNGSINH()
                             + "," + sinhvien.getPHAI()
                             + "," + sinhvien.getMAL());
				}else {
                    JOptionPane.showMessageDialog(view, "Thao tác với Sinh Viên thất bại");
                }
            } else {
                JOptionPane.showMessageDialog(view, "Thao tác với Sinh Viên thất bại");
            }
        }
        else if ("Thi".equals(selectedModel)) {
            Thi thi = InputThi.showInputDialog();
            if (thi != null) {
                // TODO: Thực hiện thao tác với đối tượng thi để lưu vào cơ sở dữ liệu.
             
                int UpdateResurt = ThiDataAccessObject.getInstance().Uppdate(thi);
               if (UpdateResurt > 0) {
                	 JOptionPane.showMessageDialog(view, "Đã cập nhật Thi mới: " 
                             +thi.getMaMT()
                             + "," + thi.getMaCN());
				} else {
                    JOptionPane.showMessageDialog(view, "Thao tác với Thi thất bại");
                }
            } else {
                JOptionPane.showMessageDialog(view, "Thao tác với Thi thất bại");
            }
        }   
    }
    private void AcctionDelete(String selectedModel) {
        if ("ChuyenNganh".equals(selectedModel)) {
            ChuyenNganh chuyenNganh = InputChuyenNganh.showInputDialog();
            if (chuyenNganh != null) {
                // TODO: Thực hiện thao tác với đối tượng chuyenNganh đểlưu vào cơ sở dữ liệu.
                // Ví dụ: chuyenNganhDAO.insert(chuyenNganh); .....
               
                int DeleteResurt = ChuyenNghanhDataAccessObject.getInstance().Delete(chuyenNganh);
               if (DeleteResurt > 0) {
                	JOptionPane.showMessageDialog(view, "Đã xóa Chuyên Ngành: " 
                			 + chuyenNganh.getMACN()
                             +"," + chuyenNganh.getTENCN()
                             +"," + chuyenNganh.getMAGVQL()
                             +"," + chuyenNganh.getMAKHOA());
				} else {
                    JOptionPane.showMessageDialog(view, "Thao tác với Chuyên Nghành thất bại ");
                }}
             else {
                JOptionPane.showMessageDialog(view, "Thao tác với Chuyên Nghành thất bại");
            }
        }
        
        else if ("DiaChi".equals(selectedModel)) {
            DiaChi diachi = InputDiaChi.showInputDialog();
            if (diachi != null) {
                // TODO: Thực hiện thao tác với đối tượng diachi để lưu vào cơ sở dữ liệu.
               
                int DeleteResurt = DiaChiDataAccessObject.getInstance().Delete(diachi);
               if (DeleteResurt > 0) {
                	JOptionPane.showMessageDialog(view, "Đã xóa Địa Chỉ: " 
                            +diachi.getMASV()
                            + "," + diachi.getSONhA()
                            + "," + diachi.getDUONG()
                            + "," + diachi.getQUAN()
                            + "," + diachi.getTHANHPHO());
				} else {
                    JOptionPane.showMessageDialog(view, "Thao tác với Địa Chỉ thất bại");
                }
            } else {
                JOptionPane.showMessageDialog(view, "Thao tác với Địa Chỉ thất bại");
            }
        }
        else if ("DiemThi".equals(selectedModel)) {
            DiemThi diemthi = InputDiemThi.showInputDialog();
            if (diemthi != null ) {
                // TODO: Thực hiện thao tác với đối tượng DiemThi để lưu vào cơ sở dữ liệu.
               int DeleteResurt = DiemThiDataAccessObject.getInstance().Delete(diemthi);
                if (DeleteResurt > 0) {
					JOptionPane.showMessageDialog(view, "Đã xóa Điểm Thi: " 
                            +diemthi.getMASV()
                            + "," + diemthi.getMAMT()
                            + "," + diemthi.getDIEM()
                            + "," + diemthi.getGHICHU());
				} else {
                    JOptionPane.showMessageDialog(view, "Thao tác với Điểm Thi thất bại");
                }
            } else {
            	JOptionPane.showMessageDialog(view, "Thao tác với Điểm thi thất bại");
            }
        }
        else if ("DienThoai".equals(selectedModel)) {
            DienThoai dienthoai = InputDienThoai.showInputDialog();
            if (dienthoai != null) {
                // TODO: Thực hiện thao tác với đối tượng DienThoai để lưu vào cơ sở dữ liệu.
               
                int DeleteResurt = DienThoaiDataAccessObject.getInstance().Delete(dienthoai);
               if (DeleteResurt > 0) {
                	 JOptionPane.showMessageDialog(view, "Đã xóa Điện Thoại: " 
                             +dienthoai.getMASV()
                             + "," + dienthoai.getSODT());
				} else {
                    JOptionPane.showMessageDialog(view, "Thao tác với Điện Thọai thất bại");
                }
            } else {
                JOptionPane.showMessageDialog(view, "Thao tác với Điện thọai thất bại");
            }
        }
        else if ("GiangVien".equals(selectedModel)) {
            GiangVien giangvien = InputGiangVien.showInputDialog();
            if (giangvien != null) {
                // TODO: Thực hiện thao tác với đối tượng GiangVien để lưu vào cơ sở dữ liệu.
               
                int DeleteResurt = GiangVienDataAccessObject.getInstance().Delete(giangvien);
                if (DeleteResurt > 0) {
					JOptionPane.showMessageDialog(view, "Đã xóa Giảng Viên: " 
                            +giangvien.getMAGV()
                            + "," + giangvien.getTENGV()
                            + "," + giangvien.getSODT()
                            + "," + giangvien.getMAKHOA());
				} else {
                    JOptionPane.showMessageDialog(view, "Thao tác với Giảng Viên thất bại");
                }
            } else {
                JOptionPane.showMessageDialog(view, "Thao tác với Giảng Viên thất bại");
            }
        }
        else if ("Khoa".equals(selectedModel)) {
            Khoa khoa = InputKhoa.showInputDialog();
            if (khoa != null) {
                // TODO: Thực hiện thao tác với đối tượng Khoa để lưu vào cơ sở dữ liệu.
               
                int DeleteResurt = KhoaDataAccessObject.getInstance().Delete(khoa);
                if (DeleteResurt > 0) {
					JOptionPane.showMessageDialog(view, "Đã xóa Khoa: " 
                            +khoa.getMAKHOA()
                            + "," + khoa.getTENKHOA()
                            + "," + khoa.getNAMTL()
                            + "," + khoa.getPHONGLV()
                            + "," + khoa.getTEL()
                            + "," + khoa.getMATRGKHOA());
				} else {
                    JOptionPane.showMessageDialog(view, "Thao tác với Khoa thất bại");
                }
            } else {
                JOptionPane.showMessageDialog(view, "Thao tác với Khoa thất bại");
            }
        }
        else if ("Lop".equals(selectedModel)) {
            Lop lop = InputLop.showInputDialog();
            if (lop != null) {
                // TODO: Thực hiện thao tác với đối tượng lop để lưu vào cơ sở dữ liệu.
                
                int DeleteResurt = lopDataAccessObject.getInstance().Delete(lop);
                if (DeleteResurt > 0) {
					 JOptionPane.showMessageDialog(view, "Đã xóa Lớp: " 
                             +lop.getMAL()
                             + "," + lop.getSISO()
                             + "," + lop.getMACN());
				} else {
                    JOptionPane.showMessageDialog(view, "Thao tác với Lớp thất bại");
                }
            } else {
                JOptionPane.showMessageDialog(view, "Thao tác với Lớp thất bại");
            }
        }
        else if ("MonThi".equals(selectedModel)) {
            MonThi  monthi = InputMonThi.showInputDialog();
            if (monthi != null) {
                // TODO: Thực hiện thao tác với đối tượng monthi để lưu vào cơ sở dữ liệu.
                
                int DeleteResurt = MonThiDataAccessObject.getInstance().Delete(monthi);
                if (DeleteResurt > 0) {
					JOptionPane.showMessageDialog(view, "Đã xóa Môn Thi: " 
                            +monthi.getMaMT()
                            + "," + monthi.getTENMT());
				} else {
                    JOptionPane.showMessageDialog(view, "Thao tác với Môn Thi thất bại");
                }
            } else {
                JOptionPane.showMessageDialog(view, "Thao tác với Môn Thi thất bại");
            }
        }
        else if ("SinhVien".equals(selectedModel)) {
            SinhVien  sinhvien = InputSinhVien.showInputDialog();
            if (sinhvien != null) {
                // TODO: Thực hiện thao tác với đối tượng sinhvien để lưu vào cơ sở dữ liệu.
                
                int DeleteResurt = SinhVienDataAccessObject.getInstance().Delete(sinhvien);
               if (DeleteResurt > 0 ) {
					JOptionPane.showMessageDialog(view, "Đã xóa Sinh Viên: " 
                            +sinhvien.getMASV()
                            + "," + sinhvien.getHOTEN()
                            + "," + sinhvien.getNGSINH()
                            + "," + sinhvien.getPHAI()
                            + "," + sinhvien.getMAL());
				} else {
                    JOptionPane.showMessageDialog(view, "Thao tác với Sinh Viên thất bại");
                }
            } else {
                JOptionPane.showMessageDialog(view, "Thao tác với Sinh Viên thất bại");
            }
        }
        else if ("Thi".equals(selectedModel)) {
            Thi thi = InputThi.showInputDialog();
            if (thi != null) {
                // TODO: Thực hiện thao tác với đối tượng thi để lưu vào cơ sở dữ liệu.
                
                int DeleteResurt = ThiDataAccessObject.getInstance().Delete(thi);
                if (DeleteResurt > 0) {
					 JOptionPane.showMessageDialog(view, "Đã xóa Thi: " 
                             +thi.getMaMT()
                             + "," + thi.getMaCN());
				} else {
                    JOptionPane.showMessageDialog(view, "Thao tác với Thi thất bại");
                }
            } else {
                JOptionPane.showMessageDialog(view, "Thao tác với Thi thất bại");
            }
        }   
    }
    
    	
    }
 
