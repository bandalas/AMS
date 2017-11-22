package view;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;

import controller.ViewDataController;

public class ViewData extends JFrame{
	private javax.swing.JLabel Condition;
    private javax.swing.JLabel CuartoLbl;
    private javax.swing.JLabel Symptoms;
    private javax.swing.JLabel addressRelati;
    private javax.swing.JLabel bed;
    private javax.swing.JLabel bedLbl;
    private javax.swing.JLabel birthDate;
    private javax.swing.JLabel birthLbl;
    private javax.swing.JLabel condition2;
    private javax.swing.JLabel conditionSev2;
    private javax.swing.JLabel conditionSeverity;
    private javax.swing.JLabel conditionType2;
    private javax.swing.JLabel contiditonType;
    private javax.swing.JLabel datePres;
    private javax.swing.JLabel description;
    private javax.swing.JLabel doctor;
    private javax.swing.JLabel dose;
    private javax.swing.JLabel dose2;
    private javax.swing.JLabel dose3;
    private javax.swing.JLabel duration;
    private javax.swing.JLabel duration2;
    private javax.swing.JLabel duration3;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel lastNames;
    private javax.swing.JLabel lastNamesLbl;
    private javax.swing.JLabel name;
    private javax.swing.JLabel nameLbl;
    private javax.swing.JLabel nameMed;
    private javax.swing.JLabel nameMed2;
    private javax.swing.JLabel nameMed3;
    private javax.swing.JLabel relativeLast;
    private javax.swing.JLabel relativeName;
    private javax.swing.JLabel room;
    private javax.swing.JLabel status;
    private javax.swing.JLabel statusLbl;
    private javax.swing.JLabel telephoneRelat;
    
    private ViewDataController vdc;
    private ArrayList<String> data;
    private ArrayList<JLabel> labels;

   
    public ViewData(String id) {
    		super();
    		vdc = new ViewDataController(id);
    		data = new ArrayList<String>();
    		labels = new ArrayList<JLabel>();
    		initComponents();
    		
 
    		
    }
    
    
    private void initComponents() {
    		data = vdc.getData();

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();      
        bedLbl = new javax.swing.JLabel();    
        CuartoLbl = new javax.swing.JLabel();
        nameLbl = new javax.swing.JLabel();
        lastNamesLbl = new javax.swing.JLabel();
        birthLbl = new javax.swing.JLabel();
        statusLbl = new javax.swing.JLabel();
        
        jSeparator1 = new javax.swing.JSeparator();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel21 = new javax.swing.JLabel();
        
        
        status = new javax.swing.JLabel();
        birthDate = new javax.swing.JLabel();
        lastNames = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        room = new javax.swing.JLabel();
        bed = new javax.swing.JLabel();
        relativeLast = new javax.swing.JLabel();
        relativeName = new javax.swing.JLabel();
        addressRelati = new javax.swing.JLabel();
        telephoneRelat = new javax.swing.JLabel();
        Condition = new javax.swing.JLabel();
        condition2 = new javax.swing.JLabel();
        contiditonType = new javax.swing.JLabel();
        conditionType2 = new javax.swing.JLabel();
        
      
        
        jSeparator3 = new javax.swing.JSeparator();
        jLabel29 = new javax.swing.JLabel();
        conditionSeverity = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        conditionSev2 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        doctor = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        Symptoms = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        datePres = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        description = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel41 = new javax.swing.JLabel();
        nameMed = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        duration = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        dose = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        nameMed2 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        duration2 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        dose2 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        nameMed3 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        duration3 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        dose3 = new javax.swing.JLabel();
        
        labels.add(room);
        labels.add(bed);
        labels.add(name);
        labels.add(lastNames);
        labels.add(birthDate);
        labels.add(status);
        labels.add(Condition);
        labels.add(contiditonType);
        labels.add(conditionSeverity);
        labels.add(doctor);
        labels.add(datePres);
        labels.add(Symptoms);
        labels.add(description);
        labels.add(nameMed);
        labels.add(duration);
        labels.add(dose);
        labels.add(nameMed2);
        labels.add(duration2);
        labels.add(dose2);
        labels.add(nameMed3);
        labels.add(duration3);
        labels.add(dose3);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bedLbl.setText("Bed");

        CuartoLbl.setText("Cuarto");

        nameLbl.setText("Nombre");

        lastNamesLbl.setText("Apellido(s)");

        name.setText("jLabel1");

        lastNames.setText("jLabel1");

        birthLbl.setText("Nacimiento");

        birthDate.setText("jLabel1");

        statusLbl.setText("Estatus");

        status.setText("jLabel1");

        jLabel21.setText("Condición");

        Condition.setText("jLabel1");

        jLabel25.setText("Tipo");

        contiditonType.setText("jLabel1");

        jLabel29.setText("Severidad");

        conditionSeverity.setText("jLabel1");

        jLabel33.setText("Doctor");

        doctor.setText("jLabel1");

        jLabel35.setText("Sintomas");

        Symptoms.setText("jLabel1");

        jLabel37.setText("Fecha de receta");

        datePres.setText("jLabel1");

        jLabel39.setText("Descripción");

        description.setText("jLabel1");

        jLabel41.setText("Medicamento");

        nameMed.setText("jLabel1");

        jLabel43.setText("Duración");

        duration.setText("jLabel1");

        jLabel45.setText("Dosis");

        dose.setText("jLabel1");

        jLabel47.setText("Medicamento");

        nameMed2.setText("jLabel1");

        jLabel49.setText("Duración");

        duration2.setText("jLabel1");

        jLabel51.setText("Dosis");

        dose2.setText("jLabel1");

        jLabel53.setText("Medicamento");

        nameMed3.setText("jLabel1");

        jLabel55.setText("Duración");

        duration3.setText("jLabel1");

        jLabel57.setText("Dosis");

        dose3.setText("jLabel1");

        int cont = 0;
        for (int i= 0; i<data.size(); i++) {
        		cont++;
    			labels.get(i).setText(data.get(i));
        }
        
        for(int i = cont ; i<labels.size(); i++) {
        		labels.get(i).setVisible(false);
        }
   

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CuartoLbl, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(room, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bedLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bed, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(birthDate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(status))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(birthLbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(statusLbl))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(name)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lastNames))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(nameLbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lastNamesLbl)))
                .addGap(265, 265, 265))
            .addComponent(jSeparator1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(relativeName)
                    .addComponent(addressRelati)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(telephoneRelat)
                    .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(relativeLast)
                    .addComponent(jLabel14))
                .addGap(266, 266, 266))
            .addComponent(jSeparator2)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21)
                    .addComponent(Condition)
                    .addComponent(condition2)
                    .addComponent(jLabel23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(conditionType2)
                    .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(contiditonType)
                    .addComponent(jLabel25))
                .addGap(183, 183, 183)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(conditionSeverity)
                    .addComponent(jLabel29)
                    .addComponent(conditionSev2)
                    .addComponent(jLabel31))
                .addGap(110, 110, 110))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jSeparator3)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel33)
                            .addComponent(doctor)
                            .addComponent(Symptoms)
                            .addComponent(jLabel35))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(description)
                            .addComponent(jLabel39, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(datePres)
                            .addComponent(jLabel37))
                        .addGap(264, 264, 264))))
            .addComponent(jSeparator4)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel41)
                            .addComponent(nameMed))
                        .addGap(232, 232, 232)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(duration)
                            .addComponent(jLabel43)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel47)
                            .addComponent(nameMed2)
                            .addComponent(nameMed3)
                            .addComponent(jLabel53))
                        .addGap(232, 232, 232)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(duration3)
                            .addComponent(jLabel55)
                            .addComponent(duration2)
                            .addComponent(jLabel49))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 183, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dose)
                    .addComponent(jLabel45)
                    .addComponent(dose3)
                    .addComponent(jLabel57)
                    .addComponent(dose2)
                    .addComponent(jLabel51))
                .addGap(112, 112, 112))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bedLbl)
                    .addComponent(CuartoLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(room, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bed, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLbl)
                    .addComponent(lastNamesLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(name)
                    .addComponent(lastNames))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(birthLbl)
                    .addComponent(statusLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(birthDate)
                    .addComponent(status))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(relativeName)
                    .addComponent(relativeLast))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addressRelati)
                    .addComponent(telephoneRelat))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Condition)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(condition2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel25)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(contiditonType))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel29)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(conditionSeverity)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel27)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(conditionType2))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel31)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(conditionSev2)))))
                .addGap(18, 18, 18)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(jLabel37))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(doctor)
                    .addComponent(datePres))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(jLabel39))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Symptoms)
                    .addComponent(description))
                .addGap(18, 18, 18)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel41)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nameMed))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel43)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(duration))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel45)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dose)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel47)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nameMed2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel49)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(duration2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel51)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dose2)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel53)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nameMed3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel55)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(duration3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel57)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dose3)))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 735, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setVisible(true);
        setLocationRelativeTo(null);
    }
	
	
	

}
