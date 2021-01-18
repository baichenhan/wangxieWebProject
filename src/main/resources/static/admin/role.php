<?php
    header('Content-Type:application/json');
    $array = [
      ['value' => 0, 'name'=>'部员'],
      ['value' => 1, 'name'=>'部长'],
      ['value' => 2, 'name'=>'主席'],
      ['value' => 3, 'name'=>'游客']
    ];
    echo json_encode($array);