#include<stdio.h>
#include<stdlib.h>
#include<time.h>
int A[256][256];
void puniMatricu(int **mat, int m, int n, int k);



main()
{
      int i,m,n,k,*mat[256];
      for(i=0;i<125;++i){
      mat[i]=A[i];   ///// inicijalizacija i alociranje memorije pokazivaca sa dvodimenzinalnim poljem
      }
      
printf("upisite velicinu matrice M x N ---> ");
scanf("%d %d",&m,&n);
printf("upisite do kojeg broja zelite generirati slucajan broj ---> ");
scanf("%d",&k);
      
      puniMatricu(mat,m,n,k);
      
      system("PAUSE");
      
      }
      
      
      
////////////////////////////////////////////////////////////////////////////////      
void puniMatricu(int **mat, int m, int n, int k)
{ 
     srand((unsigned)time(NULL));
     int i,j,z,temp1,temp2,mattmp[256][256];
     printf("Ispis :\nORIGINALNO GENERIRANA MATRICA :");
     for(i=0;i<m;i++){
     for(j=0;j<n;j++){
                     
     mat[i][j]=rand()%(k+1);
     }
     }
     
      for(i=0;i<m;i++){
                       printf("\n");
                       printf("\n");
     for(j=0;j<n;j++){
     printf("%d\t",mat[i][j]);
     }
     }
     
     printf("\n\n\nRedak UZLAZNO :");
     for(i=0;i<m;i++){
     for(j=0;j<n;j++){
     mattmp[i][j]=mat[i][j]; ///uzimanje vrijednosti original generirane matrice za drugu transformaciju po stupcu
}
}
/////  sortiranje redova -uzlazno
    for(z=0;z<m;z++){
     for(i=0;i<(n-1);i++){
     for(j=i+1;j<n;j++){
     if(mat[z][i]>mat[z][j])
     {
     
     temp1=mat[z][i];
     mat[z][i]=mat[z][j];
     mat[z][j]=temp1;
     }
                         }
                            }
                            }
     
     for(i=0;i<m;i++){
                       printf("\n");
                       printf("\n");
     for(j=0;j<n;j++){
     printf("%d\t",mat[i][j]);
                     }
                     }
                     
                     printf("\n\n\nStupac SILAZNO :");
     //// sortiranje stupaca - silazno
     
       
      for(z=0;z<n;z++){                 
      for(i=0;i<(m-1);i++){
      for(j=i+1;j<m;j++){
      if(mattmp[i][z]<
      mattmp[j][z])
      {
                 temp2=mattmp[i][z];
                 mattmp[i][z]=mattmp[j][z];
                 mattmp[j][z]=temp2;           
      }
                       
                        }
                        }
                        }

for(i=0;i<m;i++){
                 printf("\n\n");
                 for(j=0;j<n;j++){
                                  printf("%d\t",mattmp[i][j]);
                 }
                 }
                                  
                                  
     
    
     
     }
