<?php
    header('Content-Type:application/json');
    $array = [
      ['value' => 0, 'name'=>'运维部'],
      ['value' => 1, 'name'=>'开发部'],
      ['value' => 2, 'name'=>'组宣部'],
      ['value' => 3, 'name'=>'CTF部']
    ];
    echo json_encode($array);