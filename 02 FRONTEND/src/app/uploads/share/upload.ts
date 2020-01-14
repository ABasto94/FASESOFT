export class Upload {
    $Key: String;
    file: File;
    name: String;
    url: String;
    progress: Number;
    createAt: Date = new Date();

    constructor(file :File){
        this.file = file;

    }
}

