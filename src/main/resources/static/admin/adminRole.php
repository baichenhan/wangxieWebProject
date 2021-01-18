<?php
header('Content-Type:application/json');
$array = [
    'code'    => 0,
    'msg'     => '',
    'count'   => 2,
    'data'    => [
        [
            'id'              => 1,
            'role'            => '超级管理员',
            'status'          => 1,
            'rule'            => '会员列表，问题列表'],
        [
            'id'              => 1,
            'role'            => '超级管理员',
            'status'          => 1,
            'rule'            => '会员列表，问题列表']
    ]
];

echo json_encode($array);

