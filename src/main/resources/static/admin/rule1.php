<?php
    header('Content-Type:application/json');
    $array = [[
        'id'        => '1',
        'cate'      => '管理员管理1',
        'rule'      => [
            ['value' => 'admin/add', 'name' => '管理员人员添加'],
            ['value' => 'admin/edit', 'name' => '管理员人员编辑'],
            ['value' => 'admin/detail', 'name' => '管理员人员详情']
        ]
    ],[
        'id'        => '2',
        'cate'      => '管理员管理2',
        'rule'      => [
            ['value' => 'admin/add', 'name' => '管理员人员添加'],
            ['value' => 'admin/edit', 'name' => '管理员人员编辑'],
            ['value' => 'admin/detail', 'name' => '管理员人员详情']
        ]
    ],[
        'id'        => '3',
        'cate'      => '管理员管理3',
        'rule'      => [
            ['value' => 'admin/add', 'name' => '管理员人员添加'],
            ['value' => 'admin/edit', 'name' => '管理员人员编辑'],
            ['value' => 'admin/detail', 'name' => '管理员人员详情']
    ]]];
    echo json_encode($array);