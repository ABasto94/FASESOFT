import { Component, OnInit } from '@angular/core';
import { Upload } from '../share/upload';
import { UploadService } from '../share/upload.service';

@Component({
  selector: 'app-upload-forms',
  templateUrl: './upload-forms.component.html',
  styleUrls: ['./upload-forms.component.css']
})
export class UploadFormsComponent implements OnInit {

  selectedFiles: FileList;
  currentUpload: Upload;
  

  constructor(private upservice : UploadService) { }

  ngOnInit() {
  }

  detectarFiles(event){
    this.selectedFiles = event.target.files;
  }

  uploadFile(){
    let file = this.selectedFiles.item(0);
    this.currentUpload = new Upload(file);
    
    //se llama para la subida del archivo
    this.upservice.subirFile(this.currentUpload);
    //se obtiene la url del archivo
    this.upservice.urlRespuesta.subscribe(url=>{
        console.log(url);
    });
  }
}
