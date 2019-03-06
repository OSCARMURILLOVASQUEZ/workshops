import java.io.IOException;
import org.snmp4j.CommunityTarget;
import org.snmp4j.PDU;
import org.snmp4j.Snmp;
import org.snmp4j.TransportMapping;
import org.snmp4j.event.ResponseEvent;
import org.snmp4j.smi.Address;
import org.snmp4j.smi.OID;
import org.snmp4j.smi.OctetString;
import org.snmp4j.smi.UdpAddress;
import org.snmp4j.smi.VariableBinding;
import org.snmp4j.transport.DefaultUdpTransportMapping;

public class PrinterSNMPFrame extends javax.swing.JFrame {
    
    public String community;
    public CommunityTarget target;
    public OID OIDSystem,OIDSysuptime,OIDSysLanguaje;
    public OID OIDTonerLimit, OIDTonerID, OIDTonerState, OIDTonerColor;
    public OID OIDPaperState;
    public String SystemName,SystemTime,SysLanguaje;
    public String TonerLimit,TonerID,TonerState,TonerColor;
    public String PaperState;
    
    /** Creates new form PrinterSNMPFrame */
    public PrinterSNMPFrame() {
        initComponents();
        //System OID's
        OIDSystem= new OID("1.3.6.1.2.1.1.1.0");
        OIDSysuptime= new OID("1.3.6.1.2.1.1.3.0");
        OIDSysLanguaje= new OID("1.3.6.1.2.1.43.7.1.1.2.1.1");
        //Toner OID's'
        OIDTonerID=new OID("1.3.6.1.2.1.43.11.1.1.6.1.1");
        OIDTonerLimit=new OID("1.3.6.1.2.1.43.11.1.1.8.1.1");
        OIDTonerState=new OID("1.3.6.1.2.1.43.11.1.1.9.1.1");
        OIDTonerColor=new OID("1.3.6.1.2.1.43.12.1.1.4.1.1");
        //Paper OID's'
        OIDPaperState=new OID("1.3.6.1.2.1.43.13.4.1.11.1.1");
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] { {"Name", null}, {"Time on Line", null}, {"Languaje", null},
                               {"Toner ID", null}, {"Toner Max", null}, {"Toner Value", null},
                               {"Toner Color", null}, {"Paper Status", null}},
            new String [] {"Name", "Value"})
            { Class[] types = new Class [] { java.lang.String.class, java.lang.String.class };
                boolean[] canEdit = new boolean [] { false, false };
                public Class getColumnClass(int columnIndex) { return types [columnIndex]; }
                public boolean isCellEditable(int rowIndex, int columnIndex) { return canEdit [columnIndex]; } });
        }
    
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jSeparator1 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jProgressBar1 = new javax.swing.JProgressBar();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        getContentPane().setLayout(null);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        jLabel1.setFont(new java.awt.Font("Arial", 1, 18));
        jLabel1.setText("SNMP Printer Viewer");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(210, 10, 210, 20);

        jLabel2.setFont(new java.awt.Font("Arial", 0, 10));
        jLabel2.setText("Dispositivo: ");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 50, 80, 20);

        jLabel4.setFont(new java.awt.Font("Arial", 0, 10));
        jLabel4.setText("Comunity Name :");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(30, 80, 90, 20);

        jTextField1.setFont(new java.awt.Font("Arial", 0, 12));
        getContentPane().add(jTextField1);
        jTextField1.setBounds(110, 50, 210, 20);

        jPasswordField1.setFont(new java.awt.Font("Arial", 0, 12));
        getContentPane().add(jPasswordField1);
        jPasswordField1.setBounds(110, 80, 131, 20);

        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(20, 40, 350, 10);

        jButton1.setText("Obtener Datos");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        getContentPane().add(jButton1);
        jButton1.setBounds(440, 290, 140, 23);

        getContentPane().add(jSeparator2);
        jSeparator2.setBounds(20, 110, 350, 10);

        jProgressBar1.setEnabled(false);
        jProgressBar1.setOpaque(true);
        jProgressBar1.setStringPainted(true);
        getContentPane().add(jProgressBar1);
        jProgressBar1.setBounds(390, 250, 180, 20);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Name", "Value"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(30, 120, 330, 150);

        getContentPane().add(jSeparator3);
        jSeparator3.setBounds(20, 280, 350, 20);

        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator4);
        jSeparator4.setBounds(370, 40, 20, 240);

        jSeparator5.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator5);
        jSeparator5.setBounds(20, 40, 10, 240);

        getContentPane().add(jSeparator6);
        jSeparator6.setBounds(360, 40, 220, 2);

        getContentPane().add(jSeparator7);
        jSeparator7.setBounds(370, 280, 210, 10);

        jSeparator8.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator8);
        jSeparator8.setBounds(580, 40, 10, 240);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel3.setText("Nivel de Tinta");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(390, 220, 90, 15);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/printer.jpg")));
        jLabel5.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(jLabel5);
        jLabel5.setBounds(390, 50, 170, 150);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
            char passwordcom[];
            passwordcom = jPasswordField1.getPassword();
            community = String.valueOf(passwordcom);
            target = new CommunityTarget();
	    Address targetaddress = new UdpAddress(jTextField1.getText()+"/161");
	    target.setAddress(targetaddress);
	    target.setCommunity(new OctetString(community));
	    target.setTimeout(2000);
	    target.setVersion(0);
	    target.setRetries(1);
            SystemName=getvaluebyOID(OIDSystem,2);
            SystemTime=getvaluebyOID(OIDSysuptime,3);
            PaperState=getvaluebyOID(OIDSysLanguaje,1);
            SysLanguaje=getvaluebyOID(OIDTonerID,1);
            TonerID=getvaluebyOID(OIDTonerState,2);
            TonerState=getvaluebyOID(OIDTonerLimit,1);
            TonerLimit=getvaluebyOID(OIDTonerColor,1);
            TonerColor=getvaluebyOID(OIDPaperState,1);
            System.out.println("System: "+SystemName+"-"+SystemTime+"-"+SysLanguaje);
            System.out.println("Toner: "+TonerLimit+"-"+TonerID+"-"+TonerState+"-"+TonerColor);
            System.out.println("Paper: "+PaperState);
            jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] { {"Name", SystemName}, {"Time on Line", SystemTime}, {"Languaje", SysLanguaje},
                               {"Toner ID", TonerID}, {"Toner Max", TonerLimit}, {"Toner Value", TonerState},
                               {"Toner Color", TonerColor}, {"Paper Status", PaperState}},
            new String [] {"Name", "Value"})
            { Class[] types = new Class [] { java.lang.String.class, java.lang.String.class };
                boolean[] canEdit = new boolean [] { false, false };
                public Class getColumnClass(int columnIndex) { return types [columnIndex]; }
                public boolean isCellEditable(int rowIndex, int columnIndex) { return canEdit [columnIndex]; } });
            jProgressBar1.setMaximum(Integer.parseInt(TonerLimit)/1000);
            jProgressBar1.setValue(Integer.parseInt(TonerState)/1000);
    }//GEN-LAST:event_jButton1ActionPerformed
    
   public static void main(String args[]) {
        PrinterSNMPFrame psf= new PrinterSNMPFrame();
        psf.setSize(610,370);
        psf.setTitle(".:: SNMP Printer Viewer :: Hecho por Diego Rincon ::.");
        psf.setResizable(false);
        psf.setVisible(true);
    }
   
    public String getvaluebyOID(OID itemID,int numVal)
        {   PDU pdu = new PDU();
            PDU response=null;
            pdu.setType(pdu.GET);
            pdu.add(new VariableBinding(itemID));
        try {
            TransportMapping transport = new DefaultUdpTransportMapping();
            transport.listen();
            Snmp snmp= new Snmp(transport);
	    ResponseEvent respEv = snmp.send(pdu, target);
	    response = respEv.getResponse();
	} catch (IOException e) {
		e.printStackTrace();
	}
        String value=response.getVariableBindings().get(0).toString();
        try {
            switch (numVal){
                case 1: value = value.split(" ")[2]; break;
                case 2: value = value.split(" ")[2]+value.split(" ")[3]; break;
                case 3: value = value.split(" ")[2]+value.split(" ")[3]+value.split(" ")[4]; break;
            }
            value = value.split(" ")[2];
        } catch(Exception e) {
        }
          return value;
         }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
    
}