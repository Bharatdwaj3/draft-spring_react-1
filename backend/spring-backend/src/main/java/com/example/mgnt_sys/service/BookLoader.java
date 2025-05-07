package com.example.mgnt_sys.service;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.mgnt_sys.model.Book;
import com.example.mgnt_sys.repository.BookRepository;


import org.springframework.stereotype.Service;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;

@Service
public class BookLoader {
    @Autowired
    private BookRepository bookRepository;
    public void loadBooks(){
        String folderPath="E:/Books/";
        File folder = new File(folderPath);
        if(!folder.exists() || !folder.isDirectory()){
            System.out.println("Invalid Folder Path !! " + folderPath);
            return;
        }
        File[] files = folder.listFiles((dir, name)->
            name.toLowerCase().endsWith(".pdf"));
        if(files==null){
            System.out.println("No Files found !! ");
            return;
        }
        for(File pdfFile : files){
            try(PDDocument document = PDDocument.load(pdfFile)){
                PDFTextStripper stripper = new PDFTextStripper();
                String text = stripper.getText(document);

                String title = pdfFile.getName().replace(".pdf", "");
                String writer = "Unknown";
                String genre = "Uncategorized";

                if(text != null && text.length()>20){
                    String[] lines = text.split("\n");
                    for(String line : lines){
                        if(line.toLowerCase().contains("author")){
                            writer = line.split(":")[1].trim();
                        }
                        if(line.toLowerCase().contains("author")){
                            writer = line.split(":")[1].trim();
                        }
                    }
                }
                Book book = new Book();
                book.setBookName(title);
                book.setBookWriter(writer);
                book.setBookGenre(genre);
                book.setBookPublisher("Unknown");
                book.setBookFileFormat("PDF");
                book.setBookPages(document.getNumberOfPages());
                book.setBookISBN(0);
                book.setCompleted(false);

                bookRepository.save(book);
                System.out.println("Saved "+ title);
            }catch(Exception e){
                System.out.println("Failed to process " + pdfFile.getName());
                e.printStackTrace();
            }
        }
    }
}