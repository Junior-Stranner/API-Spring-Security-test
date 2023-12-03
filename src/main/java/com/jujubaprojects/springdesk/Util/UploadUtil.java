package com.jujubaprojects.springdesk.Util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.springframework.web.multipart.MultipartFile;

public class UploadUtil {
    
    /**
     * @param imagem
     * @return
     */
    public static boolean fazerUploadImagem(MultipartFile imagem){

        boolean sucessUpload = false;

        if(!imagem.isEmpty()){
            String nomeArquivo = imagem.getOriginalFilename();

            try {
                
                //criando diretório para armazenar o arquivo
               String pastaUploadImagem = "D:\\ADS\\Programacão( Back End)\\Java\\JavaAtHome\\Projetos Junior - Spring Boot + Tymeleaf\\springdesk\\src\\main\\resources\\static\\imagens\\img-uploads";
               File dir = new File(pastaUploadImagem);

               /*se o diretório não existir eu vou criar um novo diretório */
               if(!dir.exists()){
                   dir.mkdirs();
               }

               /* Criando o Arquivo no Diretório */
               File serverFile = new File(dir.getAbsolutePath() + File.separator + nomeArquivo);


               /*Pegando a Instancia  FileOutputStream(serverFile) com o objeto serverFile dentro e passa o
                *  new FileOutputStream(serverFile) para o objeto BufferedOutputStream*/
               BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));

               stream.write(imagem.getBytes());
               stream.close();

               System.out.println("Armazenado em: "+ serverFile.getAbsolutePath());
               System.out.println("Você fez o upload do Arquivo "+nomeArquivo + "com sucesso!");
               sucessUpload = true;

            } catch (Exception e) {
                // TODO: handle exception
                System.out.println("Você falhou em carregar o arquivo : "+nomeArquivo + " => " +e.getMessage());
            }
        }else{
            System.out.println(" Você falhou em carregr o arquivo por que ele está vazio!");

        }
        return sucessUpload;

    }
}
