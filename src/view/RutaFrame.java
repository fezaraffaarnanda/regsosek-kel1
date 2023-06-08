/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author zein
 */
public class RutaFrame extends JFrame {
    private final JTextField provinsiTextField;
    private final JTextField kabKotTextField;
    private final JTextField kecamatanTextField;
    private final JTextField desaKelTextField;
    private final JTextField kodeSLSTextField;
    private final JTextField kodeSubSLSTextField;
    private final JTextField noBangunanTextField;
    private final JTextField noKeluargaTextField;
    private final JTextField idLandmarkTextField;
    private final JComboBox<String> jenisWilayahComboBox;
    private final JButton addButton;
    private final JButton artButton;
    private final JButton editButton;
    private final JButton deleteButton;
    private final JTable table;

    public RutaFrame() {
        setTitle("REGSOSEK");
        setSize(960, 720);

        WindowListener wndCloser = new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        };
        addWindowListener(wndCloser);

        String data[][] = {
            {"101", "102", "", "", "", "", "", "", "", ""},
            {"103", "104", "", "", "", "", "", "", "", ""},
            {"105", "106", "", "", "", "", "", "", "", ""},
        };
        String column[] = new String[] {
            "Provinsi",
            "Kabupaten/Kota",
            "Kecamatan",
            "Desa/Kelurahan",
            "SLS",
            "Sub SLS",
            "Jenis Wilayah",
            "No Bangunan",
            "No Keluarga",
            "ID Landmark"
        };

        JPanel mainPanel = new JPanel();
        JPanel inputPanel = new JPanel();
        JPanel controlPanel = new JPanel();

        provinsiTextField = new JTextField(16);
        kabKotTextField = new JTextField(16);
        kecamatanTextField = new JTextField(16);
        desaKelTextField = new JTextField(16);
        kodeSLSTextField = new JTextField(7);
        kodeSubSLSTextField = new JTextField(7);
        noBangunanTextField = new JTextField(16);
        noKeluargaTextField = new JTextField(16);
        idLandmarkTextField = new JTextField(16);
        jenisWilayahComboBox = new JComboBox<>(new String[] {"tes", "doang"});

        addButton = new JButton("Tambah");
        artButton = new JButton("Edit ART");
        editButton = new JButton("Ubah");
        deleteButton = new JButton("Hapus");
        table = new JTable(data, column);

        JScrollPane jsp = new JScrollPane(table);
        jsp.setPreferredSize(new Dimension(800, 400));

        // input panel
        inputPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(2, 2, 2, 2);
        c.anchor = GridBagConstraints.EAST;

        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 1;
        inputPanel.add(new JLabel("Provinsi:"), c);

        c.gridx = 1;
        c.gridy = 0;
        c.gridwidth = 2;
        inputPanel.add(provinsiTextField, c);

        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1;
        inputPanel.add(new JLabel("Kabupaten/Kota:"), c);

        c.gridx = 1;
        c.gridy = 1;
        c.gridwidth = 2;
        inputPanel.add(kabKotTextField, c);

        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 1;
        inputPanel.add(new JLabel("Kecamatan:"), c);

        c.gridx = 1;
        c.gridy = 2;
        c.gridwidth = 2;
        inputPanel.add(kecamatanTextField, c);

        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 1;
        inputPanel.add(new JLabel("Desa/Kelurahan:"), c);

        c.gridx = 1;
        c.gridy = 3;
        c.gridwidth = 2;
        inputPanel.add(desaKelTextField, c);

        c.gridx = 0;
        c.gridy = 4;
        c.gridwidth = 1;
        inputPanel.add(new JLabel("Kode SLS:"), c);

        c.gridx = 1;
        c.gridy = 4;
        c.gridwidth = 1;
        inputPanel.add(kodeSLSTextField, c);

        c.gridx = 2;
        c.gridy = 4;
        c.gridwidth = 1;
        inputPanel.add(kodeSubSLSTextField, c);

        c.gridx = 3;
        c.gridy = 0;
        inputPanel.add(new JLabel("Jenis Wilayah:"), c);

        c.gridx = 4;
        c.gridy = 0;
        c.anchor = GridBagConstraints.WEST;
        inputPanel.add(jenisWilayahComboBox, c);
        c.anchor = GridBagConstraints.EAST;

        c.gridx = 3;
        c.gridy = 1;
        inputPanel.add(new JLabel("No Urut Bangunan:"), c);

        c.gridx = 4;
        c.gridy = 1;
        inputPanel.add(noBangunanTextField, c);

        c.gridx = 3;
        c.gridy = 2;
        inputPanel.add(new JLabel("No Urut Keluarga:"), c);
        
        c.gridx = 4;
        c.gridy = 2;
        inputPanel.add(noKeluargaTextField, c);

        c.gridx = 3;
        c.gridy = 3;
        inputPanel.add(new JLabel("ID Landmark:"), c);

        c.gridx = 4;
        c.gridy = 3;
        inputPanel.add(idLandmarkTextField, c);

        // control panel
        //FlowLayout flowLayout = new FlowLayout();
        //flowLayout.setHgap(10);
        controlPanel.setLayout(new GridLayout(4, 1));
        controlPanel.add(addButton);
        controlPanel.add(artButton);
        controlPanel.add(editButton);
        controlPanel.add(deleteButton);

        mainPanel.add(inputPanel);
        mainPanel.add(controlPanel);
        mainPanel.add(jsp);

        add(mainPanel);
    }

    public static void main(String[] args) {
        (new RutaFrame()).setVisible(true);
    }

    /**
     * @return the provinsiTextField
     */
    public JTextField getProvinsiTextField() {
        return provinsiTextField;
    }

    /**
     * @return the kabKotTextField
     */
    public JTextField getKabKotTextField() {
        return kabKotTextField;
    }

    /**
     * @return the kecamatanTextField
     */
    public JTextField getKecamatanTextField() {
        return kecamatanTextField;
    }

    /**
     * @return the desaKelTextField
     */
    public JTextField getDesaKelTextField() {
        return desaKelTextField;
    }

    /**
     * @return the kodeSLSTextField
     */
    public JTextField getKodeSLSTextField() {
        return kodeSLSTextField;
    }

    /**
     * @return the kodeSubSLSTextField
     */
    public JTextField getKodeSubSLSTextField() {
        return kodeSubSLSTextField;
    }

    /**
     * @return the noBangunanTextField
     */
    public JTextField getNoBangunanTextField() {
        return noBangunanTextField;
    }

    /**
     * @return the noKeluargaTextField
     */
    public JTextField getNoKeluargaTextField() {
        return noKeluargaTextField;
    }

    /**
     * @return the idLandmarkTextField
     */
    public JTextField getIdLandmarkTextField() {
        return idLandmarkTextField;
    }

    /**
     * @return the jenisWilayahComboBox
     */
    public JComboBox<String> getJenisWilayahComboBox() {
        return jenisWilayahComboBox;
    }

    /**
     * @return the addButton
     */
    public JButton getAddButton() {
        return addButton;
    }

    /**
     * @return the artButton
     */
    public JButton getArtButton() {
        return artButton;
    }

    /**
     * @return the editButton
     */
    public JButton getEditButton() {
        return editButton;
    }

    /**
     * @return the deleteButton
     */
    public JButton getDeleteButton() {
        return deleteButton;
    }

    /**
     * @return the table
     */
    public JTable getTable() {
        return table;
    }
}
