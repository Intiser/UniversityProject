<?php

namespace App;

use Illuminate\Database\Eloquent\Model;
use Illuminate\Foundation\Auth\User as Authenticatable;

class News extends Authenticatable
{
    public function user()
    {
    	return $this->belongsTo('App\User');
    }
}
