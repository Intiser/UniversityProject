@extends('master')

@section('title')
    About US
@endsection

@section('content')
		<html>
    <head>
        <title> </title>
        <style>
          body{
              background:white;
          }
            .ab_in p{
                color:black;

            }
            .ab_in h3{
                color:black;

            }
          .ab_in{
              float:left;
              width:33.33%;
              padding: 10px;
              box-sizing: border-box;
          }
            .ab_m h3{
                color:black;  }
          .ab_m p{
              color:black;
          }
          .ab_m{
              float:left;
              width:33.33%;
              padding: 10px;
              box-sizing: border-box;
          }
            .ab_d{
                float:left;
                width:33.33%;
                padding: 10px;
                box-sizing: border-box;
            }
          .ab_d h3{
              color:black;
          }
          .ab_d p{
              color:black;
          }
            .ab_t{
                float:left;
                width:33.33%;
                padding: 10px;
                box-sizing: border-box;
            }
          .ab_t h3{
              color:black;
          }
          .ab_t p{
              p:color:black;
          }
            .ab_i{
                float:left;
                width:33.33%;
                padding: 10px;
                box-sizing: border-box;
            }

          .ab_i h3{
              color:black;

          }
          .ab_i p{
              color:black;
          }
            .ab_j{

                float:left;
                width:33.33%;
                padding: 10px;
                box-sizing: border-box;
            }
          .ab_j h3{
              color:black;
          }
          .ab_j p{
              color:black;
          }

          .ab_nz{
              float:left;
              width:33.33%;
              padding: 10px;
              box-sizing: border-box;

          }
          .ab_nz h3{
              color:black;
          }
          .ab_nz p{
              color:black;
          }
            .ab_na h3{
                color:black;
            }
          .ab_na p{
              color:black;
          }
          .ab_na{
              float:left;
              width:33.33%;
              padding: 10px;
              box-sizing: border-box;
          }
          .ab_sk{
              float:left;
              width:33.33%;
              padding:10px;
              box-sizing: border-box;
          }
            .ab_sk h3{
                color:black;
            }

            .ab_sk p{
                color:black;
            }




        </style>

    </head>
    <body>



        <div class="ab_in">

            <img src="{{URL::asset('image1.jpg')}}" alt="profile Pic" height="200" width="200" >
            <h3><b>Syed Intiser Ahsan</b></h3>
            <p>ID:20131000000001</p>

            <p>Batch: 34th </p>
            <p>ahsanintiser@gmail.com</p>

        </div>

         <div class="ab_sk">
             <img src="{{URL::asset('image9.jpg')}}" alt="profile Pic" height="200" width="200">
             <h3><b>Sakib Shahriyar Pathan</b></h3>
             <p>ID:2013200000042</p>
             <p>Batch:35th</p>
             <p>shaheen840@gmail.com</p>

         </div>



        <div class="ab_i">
             <img src="{{URL::asset('image5.jpg')}}" alt="profile Pic" height="200" width="200">
             <h3><b>Abu Ishtiaque Fahim</b></h3>
             <p>ID:2013200000035</p>
             <p>Batch:35th</p>
             <p>droid_nightwing@yahoo.com</p>

         </div>

        <div class="ab_j">
             <img src="{{URL::asset('image6.jpg')}}" alt="profile Pic" height="200" width="200">
             <h3><b>Md Jahid Hasan</b></h3>
             <p>ID:2013200000018</p>
             <p>Batch:35th</p>
             <p>msjahid@outlook.com</p>

         </div>


         <div class="ab_d">
             <img src="{{URL::asset('image3.jpg')}}" alt="profile Pic" height="200" width="200">
             <h3><b>Rabita karim disha</b></h3>
             <p>ID:2013200000052</p>
             <p>Batch:35th</p>
             <p>rabitakarimdisha@gmail.com</p>

         </div>


        <div class="ab_m">
            <img src="{{URL::asset('image2.jpg')}}" alt="profile Pic" height="200" width="200">
            <h3><b> Mahmudul Hasan Mishu</b></h3>
            <p>ID:2014000000061</p>
            <p>Batch:36th</p>
            <p>mahmud.mishu4@gmail.com</p>

        </div>

         
         <div class="ab_t">
             <img src="{{URL::asset('image4.jpg')}}" alt="profile Pic" height="200" width="200">
             <h3><b>Tahniat Sabrina Swarna</b></h3>
             <p>ID:2014000000025</p>
             <p>Batch:36th</p>
             <p>tahniatswarna25@gmail.com</p>

         </div>
         
         
         <div class="ab_nz">
             <img src="{{URL::asset('image7.jpg')}}" alt="profile Pic" height="200" width="200">
             <h3><b>Nazma Akter</b></h3>
             <p>ID:2014100000042</p>
             <p>Batch:37th</p>
             <p>nazmalana304@gmail.com</p>

         </div>
         <div class="ab_na">
             <img src="{{URL::asset('image8.jpg')}}" alt="profile Pic" height="200" width="200">
             <h3><b>Mst.Nurun Nahar</b></h3>
             <p>ID:2014100000048</p>
             <p>Batch:37th</p>
             <p>prokritiahmed29@gmail.com</p>

         </div>
         


    </body>
    </html>
@endsection