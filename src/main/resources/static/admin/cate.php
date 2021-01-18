<?php
    header('Content-Type:application/json');
    $array = [
      ['value' => 0, 'name'=>'新闻'],
      ['value' => 1, 'name'=>'通知'],
      ['value' => 2, 'name'=>'XXX'],
      ['value' => 3, 'name'=>'XXXXX']
    ];
    echo json_encode($array);