import {Component, ElementRef, Inject, OnInit, ViewChild} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialog, MatDialogConfig, MatDialogRef} from "@angular/material/dialog";
import {ProfileStore} from "../../stores/profile.store";
import {MessagesService} from "../../shared/messages/messages.service";

@Component({
  selector: 'app-profile-image-dialog',
  templateUrl: './profile-image-dialog.component.html',
  styleUrls: ['./profile-image-dialog.component.scss']
})
export class ProfileImageDialogComponent implements OnInit {
  img: string = '' ;
  file: File | undefined;
  editMode = false;
  @ViewChild('fileInput') fileInput : ElementRef | undefined;

  constructor( @Inject(MAT_DIALOG_DATA) private imgUrl: string | undefined
               ,private dialogRef: MatDialogRef<ProfileImageDialogComponent>
              , private profileStore: ProfileStore
              , private messageService: MessagesService) {
    if(imgUrl)
      this.img = imgUrl;
  }

  ngOnInit(): void {
  }

  close() {
    this.dialogRef.close();

  }

  save() {
    this.dialogRef.close();

  }

  showFileInput() {
    if(this.fileInput)
      (this.fileInput).nativeElement.click()
  }

  onSelectFile(event: Event) {
    // @ts-ignore
    const file: File = event.target.files[0];
    if(!file) return;
    let reader = new FileReader();
     let setImage = (img: any) =>  {
      this.img = img;
      this.editMode = true;
      this.file = file;
    }

    reader.onload =  function(event : any) {
      setImage(event.target.result);
    }.bind(this);
    reader.readAsDataURL(file)


  }

  editProfileImg() {
    if(this.file) {
      this.profileStore.editProfileImg(this.file).subscribe({
        next: (imgUrl) => {
          this.profileStore.setProfileImgUrl(imgUrl);
          this.close();
          this.messageService.showSuccessForPeriodOfTime(2000, 'Profile Updated Successfully');
        },
        error: () => {
          this.messageService.showErrorForPeriodOfTime(2000,  'Failed To Update Profile Image');
          this.close();
        }
      });
    }
  }
}

export function openProfileImageDialog(dialog: MatDialog,imgUrl: string | undefined) {

  const config = new MatDialogConfig();

  // config.autoFocus = true;

  config.data = imgUrl;

  const dialogRef = dialog.open(ProfileImageDialogComponent, config);

  return dialogRef.afterClosed();
}


