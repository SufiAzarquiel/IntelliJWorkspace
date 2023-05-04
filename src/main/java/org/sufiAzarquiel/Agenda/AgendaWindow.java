package org.sufiAzarquiel.Agenda;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;

/*
 * Window
 * Two buttons, new contact and delete contact
 */
public class AgendaWindow extends JFrame {
    private Agenda agenda;
    private final File archivo = new File("agenda.obj");
    private final JTable table;

    // Constructor
    public AgendaWindow() {
        final int WIDTH = 500;
        final int HEIGHT = 600;
        setTitle("Agenda");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setSize(WIDTH, HEIGHT);

        // Save agenda on close
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                guardarAgenda();
            }
        });

        cargarAgenda();

        // Attributes
        JPanel contentPane = new JPanel();
        contentPane.setLayout(null);
        setContentPane(contentPane);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(88, 35, 302, 374);

        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setViewportBorder(new LineBorder(Color.RED));

        JButton btnAdd = new JButton("Añadir contacto");
        btnAdd.addActionListener(
                e -> addPressed());
        btnAdd.setBounds(88, 462, 118, 44);
        contentPane.add(btnAdd);

        JButton btnDelete = new JButton("Borrar contacto");
        btnDelete.addActionListener(
                e -> deletePressed());

        btnDelete.setBounds(272, 462, 118, 44);
        contentPane.add(btnDelete);

        table = new JTable();
        cargarTabla();
        scrollPane.getViewport().add(table);
        contentPane.add(scrollPane);
    }

    // Methods
    protected void deletePressed() {
        int row = table.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Selecciona un contacto");
        } else {
            if (JOptionPane.showConfirmDialog(null,
                    "¿Estas seguro de que quieres borrar este contacto?", "WARNING",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                // yes option
                this.agenda.getContactos().remove(row);
                cargarTabla();
            }  // no option

        }
    }

    protected void addPressed() {
        NuevoContacto dialog = new NuevoContacto(this, true);
        dialog.setVisible(true);
        cargarTabla();
    }

    private void cargarAgenda() {
        ObjectInputStream stream = null;

        try {
            stream = new ObjectInputStream(new FileInputStream(this.archivo));

            this.agenda = (Agenda) stream.readObject();
        } catch (FileNotFoundException e) {
            // Create new agenda file
            this.agenda = new Agenda();
        } catch (IOException e) {
            System.out.println("Error: no puedo leer el dato");
        } catch (ClassNotFoundException e) {
            System.out.println("Error: no puedo encontrar la clase");
        } finally {
            try {
                if (stream != null) {
                    stream.close();
                }
            } catch (IOException | NullPointerException e) {
                System.out.println("Error: no puedo cerrar el stream");
            }
        }
    }

    private void guardarAgenda() {
        ObjectOutputStream stream = null;

        try {
            stream = new ObjectOutputStream(new FileOutputStream(this.archivo));

            stream.writeObject(this.agenda);
        } catch (FileNotFoundException e) {
            System.out.println("Error: Archivo no encontrado");
        } catch (IOException e) {
            System.out.println("Error: no puedo escribir el dato");
        } finally {
            try {
                if (stream != null) {
                    stream.close();
                }
            } catch (IOException | NullPointerException e) {
                System.out.println("Error: no puedo cerrar el stream");
            }
        }
    }

    private void cargarTabla() {
        ArrayList<Contacto> contactos = this.agenda.getContactos();
        Object[][] data = new Object[contactos.size()][2];
        // Fill data with contactos
        for (int i = 0; i < data.length; i++) {
            data[i][0] = contactos.get(i).getNombre();
            data[i][1] = contactos.get(i).getTelefono();
        }

        table.setModel(new DefaultTableModel(
                data,
                new String[]{
                        "Nombre", "Telefono"
                }) {
            final Class[] columnTypes = new Class[]{
                    String.class, Long.class
            };

            public Class getColumnClass(int columnIndex) {
                return columnTypes[columnIndex];
            }
        });
        table.getColumnModel().getColumn(0).setPreferredWidth(105);
        table.getColumnModel().getColumn(1).setPreferredWidth(88);
        table.setBounds(120, 40, 173, 113);
    }

    // Getters
    public Agenda getAgenda() {
        return agenda;
    }
}
