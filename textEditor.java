import javax.swing.*;

public class TextEditor {
    public static void main(String[] args) {
        // (main window)
        JFrame frame = new JFrame("GQ Text Editor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200,500);


        //menu bar
        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);

        //Add a file menu
        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);

        //items for file menu(new,open,save,exit)
        JMenuItem newItem = new JMenuItem("New");
        JMenuItem openItem = new JMenuItem("Open");
        JMenuItem saveItem = new JMenuItem("Save");
        JMenuItem exitItem = new JMenuItem("Exit");
        fileMenu.add(newItem);
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.add(exitItem);

        //text area
        JTextArea textArea = new JTextArea();
        JScrollPane scrollPane = new scrollPane(textArea);
        frame.add(scrollPane);

        //Diplay window
        frame.setVisible(true);


        //action listeners for open menu option
        openItem.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
                File file = fileChooser.getSelectedFile();
                try {
                    textArea.read(new FileReader(file.getAbsolutePath()), null);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });



    }
}