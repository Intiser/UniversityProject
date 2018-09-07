<?php

/*
|--------------------------------------------------------------------------
| Application Routes
|--------------------------------------------------------------------------
|
| Here is where you can register all of the routes for an application.
| It's a breeze. Simply tell Laravel the URIs it should respond to
| and give it the controller to call when that URI is requested.
|
*/

Route::group(['middleware' => ['web'] ], function () {

    Route::get('/', [
        'uses' => 'NewsController@newsAll'
        ])->name('home');

    

    Route::get('dashboard/{user_id}', [
            'uses' => 'NewsController@loadNews',
            'middleware' => 'auth'
    ])->name('dashboard');

	
    
	Route::get('user_edit',[
        'uses' => 'UserController@editPost',
        'middleware' => 'auth'
    ])->name('user_edit');

	Route::get('/editor', function () {
    		return view('editor');
	})->name('editor');

	Route::get('/about', function () {
    		return view('about');
	})->name('about');

	Route::get('/write', function () {
    		return view('write');
	})->name('write');

    Route::get('/success', function () {
            return view('success');
    })->name('success');

    Route::post('/createUser',[
    	'uses' =>       'UserController@postCreateUser', 
    	'as' => 'createUser' 
    ]);

    Route::post('/saveNews',[
        'uses' =>       'NewsController@saveNews', 
        'as' => 'saveNews' 
    ]);

    Route::post('/editNews',[
        'uses' =>       'NewsController@editNews', 
        'as' => 'editNews' 
    ]);

    Route::post('/apply',[
    	'uses' =>       'ApplicationController@applyForUser', 
    	'as' => 'apply' 
    ]);

    Route::post('/signin',[
        'uses' => 'UserController@postSignIn' ,
        'as' => 'signin'
    ]);

    Route::get('/signout',[
        'uses' =>       'UserController@getSignOut',
        'as' => 'signout'
    ]);

    Route::get('/delete-news/{news_id}', [
        'uses' => 'NewsController@getNewsDelete',
        'as' => 'news.delete',
        
    ]);

    Route::get('/edit-news/{news_id}', [
        'uses' => 'NewsController@getNewsEdit',
        'as' => 'news.edit',
        
    ]);


    Route::get('/category/{news}', [
        'uses' => 'NewsController@getNewsCategory',
        'as' => 'news.category',

    ]);

    Route::get('/newsfeed/{news_id}', [
        'uses' => 'NewsController@getNewsfeed',
        'as' => 'newsfeed'
    ]);

    Route::get('/delete-user/{user_id}', [
        'uses' => 'UserController@getUserDelete',
        'as' => 'user.delete',
        
    ]);



});